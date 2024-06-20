/**
 * 
 */
package br.com.igor.dao;

import java.util.List;

import br.com.igor.dao.generic.IGenericDAO;
import br.com.igor.domain.Cliente;


public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}
