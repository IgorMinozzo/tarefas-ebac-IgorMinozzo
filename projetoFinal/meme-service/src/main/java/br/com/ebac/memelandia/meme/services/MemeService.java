package br.com.ebac.memelandia.meme.services;

import br.com.ebac.memelandia.meme.clients.CategoriaMemeClient;
import br.com.ebac.memelandia.meme.clients.UsuarioClient;
import br.com.ebac.memelandia.meme.entities.Meme;
import br.com.ebac.memelandia.meme.repositories.MemeRepository;
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
public class MemeService {

    private static final Logger logger = LoggerFactory.getLogger(MemeService.class);

    @Autowired
    private MemeRepository memeRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    public List<Meme> listarTodos() {
        logger.info("Listando todos os memes");
        List<Meme> memes = memeRepository.findAll();
        logger.info("Encontrados {} memes", memes.size());
        return memes;
    }

    public Optional<Meme> buscarPorId(Long id) {
        logger.info("Buscando meme por ID: {}", id);
        Optional<Meme> meme = memeRepository.findById(id);
        if (meme.isPresent()) {
            logger.info("Meme encontrado: {}", meme.get().getNome());
        } else {
            logger.warn("Meme não encontrado com ID: {}", id);
        }
        return meme;
    }

    public List<Meme> buscarPorUsuario(Long usuarioId) {
        logger.info("Buscando memes por usuário ID: {}", usuarioId);
        List<Meme> memes = memeRepository.findByUsuarioId(usuarioId);
        logger.info("Encontrados {} memes para o usuário {}", memes.size(), usuarioId);
        return memes;
    }

    public List<Meme> buscarPorCategoria(Long categoriaId) {
        logger.info("Buscando memes por categoria ID: {}", categoriaId);
        List<Meme> memes = memeRepository.findByCategoriaMemeId(categoriaId);
        logger.info("Encontrados {} memes para a categoria {}", memes.size(), categoriaId);
        return memes;
    }

    public Meme memeDoDia() {
        logger.info("Buscando meme do dia");
        Meme meme = memeRepository.findRandomMeme();
        if (meme != null) {
            logger.info("Meme do dia selecionado: {}", meme.getNome());
        } else {
            logger.warn("Nenhum meme encontrado para o meme do dia");
        }
        return meme;
    }

    public Meme salvar(Meme meme) {
        logger.info("Salvando meme: {}", meme.getNome());
        
        // Verificar se o usuário existe
        try {
            UsuarioClient.UsuarioDto usuario = usuarioClient.buscarPorId(meme.getUsuarioId());
            if (usuario == null) {
                logger.error("Usuário não encontrado: {}", meme.getUsuarioId());
                throw new RuntimeException("Usuário não encontrado");
            }
            logger.info("Usuário validado: {}", usuario.getNome());
        } catch (FeignException e) {
            logger.error("Erro ao validar usuário {}: {}", meme.getUsuarioId(), e.getMessage());
            throw new RuntimeException("Usuário não encontrado");
        }

        // Verificar se a categoria existe
        try {
            CategoriaMemeClient.CategoriaMemeDto categoria = categoriaMemeClient.buscarPorId(meme.getCategoriaMemeId());
            if (categoria == null) {
                logger.error("Categoria não encontrada: {}", meme.getCategoriaMemeId());
                throw new RuntimeException("Categoria não encontrada");
            }
            logger.info("Categoria validada: {}", categoria.getNome());
        } catch (FeignException e) {
            logger.error("Erro ao validar categoria {}: {}", meme.getCategoriaMemeId(), e.getMessage());
            throw new RuntimeException("Categoria não encontrada");
        }
        
        if (meme.getDataCadastro() == null) {
            meme.setDataCadastro(Date.valueOf(LocalDate.now()));
        }
        
        Meme memeSalvo = memeRepository.save(meme);
        logger.info("Meme salvo com sucesso. ID: {}", memeSalvo.getId());
        return memeSalvo;
    }

    public Meme atualizar(Long id, Meme memeAtualizado) {
        logger.info("Atualizando meme com ID: {}", id);
        
        Optional<Meme> memeExistente = memeRepository.findById(id);
        if (!memeExistente.isPresent()) {
            logger.error("Meme não encontrado para atualização. ID: {}", id);
            throw new RuntimeException("Meme não encontrado");
        }
        
        Meme meme = memeExistente.get();
        meme.setNome(memeAtualizado.getNome());
        meme.setDescricao(memeAtualizado.getDescricao());
        meme.setUrl(memeAtualizado.getUrl());
        
        Meme memeSalvo = memeRepository.save(meme);
        logger.info("Meme atualizado com sucesso. ID: {}", memeSalvo.getId());
        return memeSalvo;
    }

    public void deletar(Long id) {
        logger.info("Deletando meme com ID: {}", id);
        
        if (!memeRepository.existsById(id)) {
            logger.error("Meme não encontrado para deleção. ID: {}", id);
            throw new RuntimeException("Meme não encontrado");
        }
        
        memeRepository.deleteById(id);
        logger.info("Meme deletado com sucesso. ID: {}", id);
    }
}

