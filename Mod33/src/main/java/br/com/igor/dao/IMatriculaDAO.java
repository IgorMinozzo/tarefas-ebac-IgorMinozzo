package br.com.igor.dao;

import java.util.List;

import br.com.igor.domain.Curso;
import br.com.igor.domain.Matricula;

public interface IMatriculaDAO {

	Matricula cadastrar(Matricula mat);
	
	void excluir (Matricula matricula);
	
	List<Matricula> buscarTodos();
	
	public Matricula buscarPorID(Long id); 
		
	public Matricula Alterar(Matricula mat);
	
	Matricula buscarPorCurso(Curso curso);
	
	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Matricula buscarPorCursoCriteria(Curso curso);
	
	Matricula buscarPorCodigoCurso(String codigoCurso);
}
