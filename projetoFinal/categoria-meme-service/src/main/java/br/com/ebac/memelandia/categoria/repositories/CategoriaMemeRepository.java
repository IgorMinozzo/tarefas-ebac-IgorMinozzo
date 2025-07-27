package br.com.ebac.memelandia.categoria.repositories;

import br.com.ebac.memelandia.categoria.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaMemeRepository extends JpaRepository<CategoriaMeme, Long> {
    List<CategoriaMeme> findByUsuarioId(Long usuarioId);
    boolean existsByNome(String nome);
}

