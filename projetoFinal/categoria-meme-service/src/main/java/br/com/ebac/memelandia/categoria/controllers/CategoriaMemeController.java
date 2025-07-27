package br.com.ebac.memelandia.categoria.controllers;

import br.com.ebac.memelandia.categoria.entities.CategoriaMeme;
import br.com.ebac.memelandia.categoria.services.CategoriaMemeService;
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
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaMemeController {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeController.class);
    
    private final Counter categoriaRequestCounter;

    @Autowired
    private CategoriaMemeService categoriaMemeService;

    public CategoriaMemeController(MeterRegistry meterRegistry) {
        this.categoriaRequestCounter = Counter.builder("categoria_requests_total")
                .description("Total de requisições para o endpoint de categorias")
                .register(meterRegistry);
    }

    @GetMapping
    @Timed(value = "categoria.listar.tempo", description = "Tempo para listar categorias")
    public ResponseEntity<List<CategoriaMeme>> listarTodas() {
        logger.info("Endpoint GET /categorias chamado");
        categoriaRequestCounter.increment();
        
        try {
            List<CategoriaMeme> categorias = categoriaMemeService.listarTodas();
            logger.info("Retornando {} categorias", categorias.size());
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            logger.error("Erro ao listar categorias: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @Timed(value = "categoria.buscar.tempo", description = "Tempo para buscar categoria por ID")
    public ResponseEntity<CategoriaMeme> buscarPorId(@PathVariable Long id) {
        logger.info("Endpoint GET /categorias/{} chamado", id);
        categoriaRequestCounter.increment();
        
        try {
            Optional<CategoriaMeme> categoria = categoriaMemeService.buscarPorId(id);
            if (categoria.isPresent()) {
                logger.info("Categoria encontrada: {}", categoria.get().getNome());
                return ResponseEntity.ok(categoria.get());
            } else {
                logger.warn("Categoria não encontrada com ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar categoria por ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    @Timed(value = "categoria.buscar.usuario.tempo", description = "Tempo para buscar categorias por usuário")
    public ResponseEntity<List<CategoriaMeme>> buscarPorUsuario(@PathVariable Long usuarioId) {
        logger.info("Endpoint GET /categorias/usuario/{} chamado", usuarioId);
        categoriaRequestCounter.increment();
        
        try {
            List<CategoriaMeme> categorias = categoriaMemeService.buscarPorUsuario(usuarioId);
            logger.info("Retornando {} categorias para o usuário {}", categorias.size(), usuarioId);
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            logger.error("Erro ao buscar categorias por usuário {}: {}", usuarioId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Timed(value = "categoria.criar.tempo", description = "Tempo para criar categoria")
    public ResponseEntity<CategoriaMeme> criar(@RequestBody CategoriaMeme categoria) {
        logger.info("Endpoint POST /categorias chamado para criar categoria: {}", categoria.getNome());
        categoriaRequestCounter.increment();
        
        try {
            CategoriaMeme categoriaSalva = categoriaMemeService.salvar(categoria);
            logger.info("Categoria criada com sucesso. ID: {}", categoriaSalva.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
        } catch (RuntimeException e) {
            logger.error("Erro ao criar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            logger.error("Erro interno ao criar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Timed(value = "categoria.atualizar.tempo", description = "Tempo para atualizar categoria")
    public ResponseEntity<CategoriaMeme> atualizar(@PathVariable Long id, @RequestBody CategoriaMeme categoria) {
        logger.info("Endpoint PUT /categorias/{} chamado", id);
        categoriaRequestCounter.increment();
        
        try {
            CategoriaMeme categoriaAtualizada = categoriaMemeService.atualizar(id, categoria);
            logger.info("Categoria atualizada com sucesso. ID: {}", categoriaAtualizada.getId());
            return ResponseEntity.ok(categoriaAtualizada);
        } catch (RuntimeException e) {
            logger.error("Erro ao atualizar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Timed(value = "categoria.deletar.tempo", description = "Tempo para deletar categoria")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        logger.info("Endpoint DELETE /categorias/{} chamado", id);
        categoriaRequestCounter.increment();
        
        try {
            categoriaMemeService.deletar(id);
            logger.info("Categoria deletada com sucesso. ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.error("Erro ao deletar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao deletar categoria: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

