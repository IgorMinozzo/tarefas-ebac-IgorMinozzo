package br.com.igor.dao;

import java.util.List;

import br.com.igor.domain.Produto;

public interface IProdutoDAO {
	
	public Produto cadastrar(Produto prod);
	
	public void excluir(Produto prod);

	public List<Produto> buscarTodos();
}
