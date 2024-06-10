package br.com.igor.dao;

import java.util.List;

import br.com.igor.domain.Aluno;

	public interface IAlunoDAO {

	public Aluno cadastrar(Aluno aluno);
	
	public void excluir(Aluno aluno);

	public List<Aluno> buscarTodos();
	
	public Aluno buscarPorID(Long id); 
		
	public Aluno Alterar(Aluno aluno);

}
