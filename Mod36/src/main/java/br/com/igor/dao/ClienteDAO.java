package br.com.igor.dao;

import br.com.igor.domain.Cliente;
import br.com.igor.generic.GenericDAO;
import br.com.igor.generic.GenericDB1DAO;

public class ClienteDAO extends GenericDB1DAO<Cliente, Long> implements IClienteDAO{

	public ClienteDAO() {
		super(Cliente.class);
	}
	
}
