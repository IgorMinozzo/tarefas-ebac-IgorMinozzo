package br.com.igor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.igor.domain.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
