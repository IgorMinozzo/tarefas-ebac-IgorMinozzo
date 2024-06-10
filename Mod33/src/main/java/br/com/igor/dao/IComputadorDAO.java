package br.com.igor.dao;

import java.util.List;

import br.com.igor.domain.Computador;


public interface IComputadorDAO {
	public Computador cadastrar(Computador comp);
	
	public void excluir(Computador comp);

	public List<Computador> buscarTodos();
	
	public Computador buscarPorID(Long id); 
		
	public Computador Alterar(Computador comp);
}	
