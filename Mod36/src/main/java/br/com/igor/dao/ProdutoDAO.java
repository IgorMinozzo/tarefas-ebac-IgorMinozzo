package br.com.igor.dao;

import br.com.igor.domain.Produto;
import br.com.igor.generic.GenericDAO;
import br.com.igor.generic.GenericDB1DAO;

public class ProdutoDAO extends GenericDB1DAO<Produto, Long> implements IProdutoDAO{

	public ProdutoDAO() {
		super(Produto.class);
	}

}
