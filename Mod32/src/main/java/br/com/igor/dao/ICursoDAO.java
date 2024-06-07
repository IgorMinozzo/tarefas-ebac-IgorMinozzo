package br.com.igor.dao;

import java.util.List;

import br.com.igor.domain.Curso;

public interface ICursoDAO {
	public Curso cadastrar(Curso curso);
	
	public void excluir(Curso cur);

	public List<Curso> buscarTodos();
	
	public Curso buscarPorID(Long id); 
		
	public Curso Alterar(Curso curso);
}
