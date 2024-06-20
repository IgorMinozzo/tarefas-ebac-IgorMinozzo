/**
 * 
 */
package br.com.igor.dao;

import java.util.List;

import br.com.igor.dao.generic.IGenericDAO;
import br.com.igor.domain.Produto;


public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
