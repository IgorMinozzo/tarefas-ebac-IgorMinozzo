package br.com.ebac.memelandia.meme.repositories;

import br.com.ebac.memelandia.meme.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
    List<Meme> findByUsuarioId(Long usuarioId);
    List<Meme> findByCategoriaMemeId(Long categoriaMemeId);
    
    @Query(value = "SELECT * FROM meme ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Meme findRandomMeme();
}

