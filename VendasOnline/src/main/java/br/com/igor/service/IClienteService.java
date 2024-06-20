/**
 * 
 */
package br.com.igor.service;

import java.util.List;

import br.com.igor.domain.Cliente;
import br.com.igor.exceptions.DAOException;
import br.com.igor.services.generic.IGenericService;


public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
