/**
 * 
 */
package br.com.igor.service;

import java.util.List;

import br.com.igor.domain.Produto;
import br.com.igor.services.generic.IGenericService;


public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
