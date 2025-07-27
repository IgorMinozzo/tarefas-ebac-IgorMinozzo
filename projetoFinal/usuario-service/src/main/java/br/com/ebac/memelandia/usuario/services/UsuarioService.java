package br.com.ebac.memelandia.usuario.services;

import br.com.ebac.memelandia.usuario.entities.Usuario;
import br.com.ebac.memelandia.usuario.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        logger.info("Listando todos os usuários");
        List<Usuario> usuarios = usuarioRepository.findAll();
        logger.info("Encontrados {} usuários", usuarios.size());
        return usuarios;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        logger.info("Buscando usuário por ID: {}", id);
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            logger.info("Usuário encontrado: {}", usuario.get().getNome());
        } else {
            logger.warn("Usuário não encontrado com ID: {}", id);
        }
        return usuario;
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        logger.info("Buscando usuário por email: {}", email);
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            logger.info("Usuário encontrado: {}", usuario.get().getNome());
        } else {
            logger.warn("Usuário não encontrado com email: {}", email);
        }
        return usuario;
    }

    public Usuario salvar(Usuario usuario) {
        logger.info("Salvando usuário: {}", usuario.getNome());
        
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            logger.error("Email já existe: {}", usuario.getEmail());
            throw new RuntimeException("Email já cadastrado");
        }
        
        if (usuario.getDataCadastro() == null) {
            usuario.setDataCadastro(Date.valueOf(LocalDate.now()));
        }
        
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        logger.info("Usuário salvo com sucesso. ID: {}", usuarioSalvo.getId());
        return usuarioSalvo;
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        logger.info("Atualizando usuário com ID: {}", id);
        
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (!usuarioExistente.isPresent()) {
            logger.error("Usuário não encontrado para atualização. ID: {}", id);
            throw new RuntimeException("Usuário não encontrado");
        }
        
        Usuario usuario = usuarioExistente.get();
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        logger.info("Usuário atualizado com sucesso. ID: {}", usuarioSalvo.getId());
        return usuarioSalvo;
    }

    public void deletar(Long id) {
        logger.info("Deletando usuário com ID: {}", id);
        
        if (!usuarioRepository.existsById(id)) {
            logger.error("Usuário não encontrado para deleção. ID: {}", id);
            throw new RuntimeException("Usuário não encontrado");
        }
        
        usuarioRepository.deleteById(id);
        logger.info("Usuário deletado com sucesso. ID: {}", id);
    }
}

