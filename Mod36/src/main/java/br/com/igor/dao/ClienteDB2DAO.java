package br.com.igor.dao;

import br.com.igor.domain.Cliente;
import br.com.igor.generic.GenericDB1DAO;
import br.com.igor.generic.GenericDB2DAO;

public class ClienteDB2DAO extends GenericDB2DAO<Cliente, Long> implements IClienteDAO{

	public ClienteDB2DAO() {
		super(Cliente.class);
	}
	
}