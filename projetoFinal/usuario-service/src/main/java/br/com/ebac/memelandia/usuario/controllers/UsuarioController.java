package br.com.ebac.memelandia.usuario.controllers;

import br.com.ebac.memelandia.usuario.entities.Usuario;
import br.com.ebac.memelandia.usuario.services.UsuarioService;
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
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
    
    private final Counter usuarioRequestCounter;

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(MeterRegistry meterRegistry) {
        this.usuarioRequestCounter = Counter.builder("usuario_requests_total")
                .description("Total de requisições para o endpoint de usuários")
                .register(meterRegistry);
    }

    @GetMapping
    @Timed(value = "usuario.listar.tempo", description = "Tempo para listar usuários")
    public ResponseEntity<List<Usuario>> listarTodos() {
        logger.info("Endpoint GET /usuarios chamado");
        usuarioRequestCounter.increment();
        
        try {
            List<Usuario> usuarios = usuarioService.listarTodos();
            logger.info("Retornando {} usuários", usuarios.size());
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            logger.error("Erro ao listar usuários: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    @Timed(value = "usuario.buscar.tempo", description = "Tempo para buscar usuário por ID")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        logger.info("Endpoint GET /usuarios/{} chamado", id);
        usuarioRequestCounter.increment();
        
        try {
            Optional<Usuario> usuario = usuarioService.buscarPorId(id);
            if (usuario.isPresent()) {
                logger.info("Usuário encontrado: {}", usuario.get().getNome());
                return ResponseEntity.ok(usuario.get());
            } else {
                logger.warn("Usuário não encontrado com ID: {}", id);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/email/{email}")
    @Timed(value = "usuario.buscar.email.tempo", description = "Tempo para buscar usuário por email")
    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email) {
        logger.info("Endpoint GET /usuarios/email/{} chamado", email);
        usuarioRequestCounter.increment();
        
        try {
            Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
            if (usuario.isPresent()) {
                logger.info("Usuário encontrado: {}", usuario.get().getNome());
                return ResponseEntity.ok(usuario.get());
            } else {
                logger.warn("Usuário não encontrado com email: {}", email);
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Erro ao buscar usuário por email {}: {}", email, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    @Timed(value = "usuario.criar.tempo", description = "Tempo para criar usuário")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        logger.info("Endpoint POST /usuarios chamado para criar usuário: {}", usuario.getNome());
        usuarioRequestCounter.increment();
        
        try {
            Usuario usuarioSalvo = usuarioService.salvar(usuario);
            logger.info("Usuário criado com sucesso. ID: {}", usuarioSalvo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
        } catch (RuntimeException e) {
            logger.error("Erro ao criar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            logger.error("Erro interno ao criar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    @Timed(value = "usuario.atualizar.tempo", description = "Tempo para atualizar usuário")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        logger.info("Endpoint PUT /usuarios/{} chamado", id);
        usuarioRequestCounter.increment();
        
        try {
            Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
            logger.info("Usuário atualizado com sucesso. ID: {}", usuarioAtualizado.getId());
            return ResponseEntity.ok(usuarioAtualizado);
        } catch (RuntimeException e) {
            logger.error("Erro ao atualizar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @Timed(value = "usuario.deletar.tempo", description = "Tempo para deletar usuário")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        logger.info("Endpoint DELETE /usuarios/{} chamado", id);
        usuarioRequestCounter.increment();
        
        try {
            usuarioService.deletar(id);
            logger.info("Usuário deletado com sucesso. ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.error("Erro ao deletar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            logger.error("Erro interno ao deletar usuário: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

