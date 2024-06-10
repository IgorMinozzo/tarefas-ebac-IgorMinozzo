package br.com.igor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.igor.dao.AlunoDAO;
import br.com.igor.dao.ComputadorDAO;
import br.com.igor.dao.CursoDAO;
import br.com.igor.dao.IAlunoDAO;
import br.com.igor.dao.IComputadorDAO;
import br.com.igor.dao.ICursoDAO;
import br.com.igor.dao.IMatriculaDAO;
import br.com.igor.dao.MatriculaDAO;
import br.com.igor.domain.Aluno;
import br.com.igor.domain.Computador;
import br.com.igor.domain.Curso;
import br.com.igor.domain.Matricula;

public class MatriculaTest {
	
	private IMatriculaDAO matriculaDAO;
	
	private ICursoDAO cursoDAO;
	
	private IAlunoDAO alunoDAO;
	
	private IComputadorDAO computadorDAO;
	
	public MatriculaTest() {
		
		matriculaDAO = new MatriculaDAO();
		
		cursoDAO = new CursoDAO();
		
		alunoDAO = new AlunoDAO();
		
		computadorDAO = new ComputadorDAO();
	}
	
	@After
	public void end() {
		List<Matricula> list = matriculaDAO.buscarTodos();
		list.forEach(mat -> matriculaDAO.excluir(mat));
		
		
	}
	
	@Test
	public void cadastrar() {
		Curso curso = criarCurso("A1");
		Aluno aluno = criarAluno("A1");
		
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat.setCurso(curso);
		mat.setAluno(aluno);
		
		aluno.setMatricula(mat);
		mat = matriculaDAO.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
		Matricula matBD = matriculaDAO.buscarPorCodigoCurso(mat.getCodigo());
		assertNotNull(matBD);
		assertEquals(mat.getId(), matBD.getId());
		
		Matricula matBDObj = matriculaDAO.buscarPorCurso(curso);
		assertNotNull(matBDObj);
		assertEquals(mat.getId(), matBDObj.getId());
	}
	
	private Curso criarCurso(String codigo) {
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		curso.setDescricao("TESTE");
		curso.setNome("TESTE");
		return cursoDAO.cadastrar(curso);
	}
	
	private Computador criarComp(String codigo) {
		Computador comp = new Computador();
		comp.setCodigo(codigo);
		comp.setDescricao("Comp 1");
		return comp;
		//return computadorDAO.cadastrar(comp);
	}
	
	private Aluno criarAluno(String codigo) {
		Computador comp = criarComp("A1");
		Computador comp2 = criarComp("A2");
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		aluno.setNome("Igor");
		aluno.add(comp);
		aluno.add(comp2);
		return alunoDAO.cadastrar(aluno);
	}
	
	
	
}
