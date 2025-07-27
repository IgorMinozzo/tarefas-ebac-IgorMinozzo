package br.com.ebac.memelandia.meme.controllers;

import br.com.ebac.memelandia.meme.entities.Meme;
import br.com.ebac.memelandia.meme.services.MemeService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memes")
@CrossOrigin(origins = "*")
public class MemeController {

    private static final Logger logger = LoggerFactory.getLogger(MemeController.class);
    
    private final Counter memeRequestCounter;

    @Autowired
    private MemeService memeService;

    public MemeController(MeterRegistry meterRegistry) {
        this.memeRequestCounter = Counter.builder("meme_requests_total")
                .description("Total de requisições para o endpoint de memes")
                .register(meterRegistry);
    }

    @GetMapping
    @Timed(value = "meme.listar.tempo", description = "Tempo para listar memes")
    public ResponseEntity<List<Meme>> listarTodos() {
        logger.info("Endpoint GET /memes chamado");
        memeRequestCounter.increment();
        
        try {
            List<Meme> memes = memeService.listarTodos();
            logger.info("Retornando {} memes", memes.size());
            return ResponseEntity.ok(memes);
        } catch (Exception e) {
            logger.error("Erro ao listar memes: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @Timed(value = "meme.buscar.tempo", description = "Tempo para buscar meme por ID")
    public ResponseEntity<Meme> buscarPorId(@PathVariable Long id) {
        logger.info("Endpoint GET /memes/{} chamado", id);
        memeRequestCounter.increment();
        
        try {
            Optional<Meme> meme = memeService.buscarPorId(id);
            if (meme.isPresent()) {
                logger.info("Meme encontrado: {}", meme.get().getNome());
                return ResponseEntity.ok(meme.get());
            } else {
                logger.warn("Meme não encontrado com ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar meme por ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    @Timed(value = "meme.buscar.usuario.tempo", description = "Tempo para buscar memes por usuário")
    public ResponseEntity<List<Meme>> buscarPorUsuario(@PathVariable Long usuarioId) {
        logger.info("Endpoint GET /memes/usuario/{} chamado", usuarioId);
        memeRequestCounter.increment();
        
        try {
            List<Meme> memes = memeService.buscarPorUsuario(usuarioId);
            logger.info("Retornando {} memes para o usuário {}", memes.size(), usuarioId);
            return ResponseEntity.ok(memes);
        } catch (Exception e) {
            logger.error("Erro ao buscar memes por usuário {}: {}", usuarioId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/categoria/{categoriaId}")
    @Timed(value = "meme.buscar.categoria.tempo", description = "Tempo para buscar memes por categoria")
    public ResponseEntity<List<Meme>> buscarPorCategoria(@PathVariable Long categoriaId) {
        logger.info("Endpoint GET /memes/categoria/{} chamado", categoriaId);
        memeRequestCounter.increment();
        
        try {
            List<Meme> memes = memeService.buscarPorCategoria(categoriaId);
            logger.info("Retornando {} memes para a categoria {}", memes.size(), categoriaId);
            return ResponseEntity.ok(memes);
        } catch (Exception e) {
            logger.error("Erro ao buscar memes por categoria {}: {}", categoriaId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/meme-do-dia")
    @Timed(value = "meme.meme.do.dia.tempo", description = "Tempo para buscar meme do dia")
    public ResponseEntity<Meme> memeDoDia() {
        logger.info("Endpoint GET /memes/meme-do-dia chamado");
        memeRequestCounter.increment();
        
        try {
            Meme meme = memeService.memeDoDia();
            if (meme != null) {
                logger.info("Meme do dia retornado: {}", meme.getNome());
                return ResponseEntity.ok(meme);
            } else {
                logger.warn("Nenhum meme encontrado para o meme do dia");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar meme do dia: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Timed(value = "meme.criar.tempo", description = "Tempo para criar meme")
    public ResponseEntity<Meme> criar(@RequestBody Meme meme) {
        logger.info("Endpoint POST /memes chamado para criar meme: {}", meme.getNome());
        memeRequestCounter.increment();
        
        try {
            Meme memeSalvo = memeService.salvar(meme);
            logger.info("Meme criado com sucesso. ID: {}", memeSalvo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(memeSalvo);
        } catch (RuntimeException e) {
            logger.error("Erro ao criar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            logger.error("Erro interno ao criar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Timed(value = "meme.atualizar.tempo", description = "Tempo para atualizar meme")
    public ResponseEntity<Meme> atualizar(@PathVariable Long id, @RequestBody Meme meme) {
        logger.info("Endpoint PUT /memes/{} chamado", id);
        memeRequestCounter.increment();
        
        try {
            Meme memeAtualizado = memeService.atualizar(id, meme);
            logger.info("Meme atualizado com sucesso. ID: {}", memeAtualizado.getId());
            return ResponseEntity.ok(memeAtualizado);
        } catch (RuntimeException e) {
            logger.error("Erro ao atualizar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Timed(value = "meme.deletar.tempo", description = "Tempo para deletar meme")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        logger.info("Endpoint DELETE /memes/{} chamado", id);
        memeRequestCounter.increment();
        
        try {
            memeService.deletar(id);
            logger.info("Meme deletado com sucesso. ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.error("Erro ao deletar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao deletar meme: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

