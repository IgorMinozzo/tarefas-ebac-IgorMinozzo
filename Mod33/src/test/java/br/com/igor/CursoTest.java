package br.com.igor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.igor.dao.CursoDAO;
import br.com.igor.dao.ICursoDAO;
import br.com.igor.domain.Curso;
import br.com.igor.domain.Matricula;

public class CursoTest {
	
	private ICursoDAO cursoDAO;
	
	public CursoTest() {
		cursoDAO = new CursoDAO();
	}
	
	@After
	public void end() {
		
		List<Curso> listCurso = cursoDAO.buscarTodos();
		listCurso.forEach(cur -> cursoDAO.excluir(cur));
	}
	
	
	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("TESTE");
		curso.setNome("TESTE");
		curso = cursoDAO.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());

	}
	
	@Test
	public void buscarTodos() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("TESTE");
		curso.setNome("TESTE");
		curso = cursoDAO.cadastrar(curso);
		
		Curso curso1 = new Curso();
		curso1.setCodigo("A2");
		curso1.setDescricao("TESTE 1");
		curso1.setNome("TESTE 1");
		curso1 = cursoDAO.cadastrar(curso1);
		
		List<Curso> list = cursoDAO.buscarTodos();
		
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void buscarPorID() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("TESTE");
		curso.setNome("TESTE");
		curso = cursoDAO.cadastrar(curso);
		assertNotNull(curso);
		
		Curso cursoBD = cursoDAO.buscarPorID(curso.getId());
		assertNotNull(cursoBD);
		assertEquals(curso.getId(), cursoBD.getId());
		assertEquals(curso.getNome(), cursoBD.getNome());
		
	}
	
	@Test
	public void alterar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("TESTE");
		curso.setNome("TESTE");
		curso = cursoDAO.cadastrar(curso);
		
		Curso cursoBD = cursoDAO.buscarPorID(curso.getId());
		assertNotNull(cursoBD);
		assertEquals(curso.getId(), cursoBD.getId());
		assertEquals(curso.getNome(), cursoBD.getNome());
		
		cursoBD.setNome("TESTE ALTERAR");
		Curso cursoUp = cursoDAO.Alterar(cursoBD);
		assertEquals("TESTE ALTERAR", cursoUp.getNome());
	}
}
