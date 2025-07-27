package br.com.ebac.memelandia.categoria.services;

import br.com.ebac.memelandia.categoria.clients.UsuarioClient;
import br.com.ebac.memelandia.categoria.entities.CategoriaMeme;
import br.com.ebac.memelandia.categoria.repositories.CategoriaMemeRepository;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaMemeService {

    private static final Logger logger = LoggerFactory.getLogger(CategoriaMemeService.class);

    @Autowired
    private CategoriaMemeRepository categoriaMemeRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<CategoriaMeme> listarTodas() {
        logger.info("Listando todas as categorias de memes");
        List<CategoriaMeme> categorias = categoriaMemeRepository.findAll();
        logger.info("Encontradas {} categorias", categorias.size());
        return categorias;
    }

    public Optional<CategoriaMeme> buscarPorId(Long id) {
        logger.info("Buscando categoria por ID: {}", id);
        Optional<CategoriaMeme> categoria = categoriaMemeRepository.findById(id);
        if (categoria.isPresent()) {
            logger.info("Categoria encontrada: {}", categoria.get().getNome());
        } else {
            logger.warn("Categoria não encontrada com ID: {}", id);
        }
        return categoria;
    }

    public List<CategoriaMeme> buscarPorUsuario(Long usuarioId) {
        logger.info("Buscando categorias por usuário ID: {}", usuarioId);
        List<CategoriaMeme> categorias = categoriaMemeRepository.findByUsuarioId(usuarioId);
        logger.info("Encontradas {} categorias para o usuário {}", categorias.size(), usuarioId);
        return categorias;
    }

    public CategoriaMeme salvar(CategoriaMeme categoria) {
        logger.info("Salvando categoria: {}", categoria.getNome());
        
        // Verificar se o usuário existe
        try {
            UsuarioClient.UsuarioDto usuario = usuarioClient.buscarPorId(categoria.getUsuarioId());
            if (usuario == null) {
                logger.error("Usuário não encontrado: {}", categoria.getUsuarioId());
                throw new RuntimeException("Usuário não encontrado");
            }
            logger.info("Usuário validado: {}", usuario.getNome());
        } catch (FeignException e) {
            logger.error("Erro ao validar usuário {}: {}", categoria.getUsuarioId(), e.getMessage());
            throw new RuntimeException("Usuário não encontrado");
        }
        
        if (categoriaMemeRepository.existsByNome(categoria.getNome())) {
            logger.error("Nome de categoria já existe: {}", categoria.getNome());
            throw new RuntimeException("Nome de categoria já cadastrado");
        }
        
        if (categoria.getDataCadastro() == null) {
            categoria.setDataCadastro(Date.valueOf(LocalDate.now()));
        }
        
        CategoriaMeme categoriaSalva = categoriaMemeRepository.save(categoria);
        logger.info("Categoria salva com sucesso. ID: {}", categoriaSalva.getId());
        return categoriaSalva;
    }

    public CategoriaMeme atualizar(Long id, CategoriaMeme categoriaAtualizada) {
        logger.info("Atualizando categoria com ID: {}", id);
        
        Optional<CategoriaMeme> categoriaExistente = categoriaMemeRepository.findById(id);
        if (!categoriaExistente.isPresent()) {
            logger.error("Categoria não encontrada para atualização. ID: {}", id);
            throw new RuntimeException("Categoria não encontrada");
        }
        
        CategoriaMeme categoria = categoriaExistente.get();
        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setDescricao(categoriaAtualizada.getDescricao());
        
        CategoriaMeme categoriaSalva = categoriaMemeRepository.save(categoria);
        logger.info("Categoria atualizada com sucesso. ID: {}", categoriaSalva.getId());
        return categoriaSalva;
    }

    public void deletar(Long id) {
        logger.info("Deletando categoria com ID: {}", id);
        
        if (!categoriaMemeRepository.existsById(id)) {
            logger.error("Categoria não encontrada para deleção. ID: {}", id);
            throw new RuntimeException("Categoria não encontrada");
        }
        
        categoriaMemeRepository.deleteById(id);
        logger.info("Categoria deletada com sucesso. ID: {}", id);
    }
}

