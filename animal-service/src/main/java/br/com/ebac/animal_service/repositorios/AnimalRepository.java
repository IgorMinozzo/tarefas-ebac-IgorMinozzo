package br.com.ebac.animal_service.repositorios;

import br.com.ebac.animal_service.dto.ResgatePorFuncionario;
import br.com.ebac.animal_service.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdapted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdapted();

    @Query("""
    SELECT new br.com.ebac.animal_service.dto.ResgatePorFuncionario(a.nomeRecebedor, COUNT(a))
    FROM Animal a
    WHERE a.dataEntrada BETWEEN :inicio AND :fim
    GROUP BY a.nomeRecebedor
""")
    List<ResgatePorFuncionario> countResgatesPorFuncionario(@Param("inicio") Date inicio, @Param("fim") Date fim);

}
