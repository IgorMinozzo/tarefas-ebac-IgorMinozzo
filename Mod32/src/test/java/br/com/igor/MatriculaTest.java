package br.com.igor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.igor.dao.IMatriculaDAO;
import br.com.igor.dao.MatriculaDAO;
import br.com.igor.domain.Curso;
import br.com.igor.domain.Matricula;

public class MatriculaTest {
	
	private IMatriculaDAO matriculaDAO;
	
	public MatriculaTest() {
		
		matriculaDAO = new MatriculaDAO();
	}
	
	@After
	public void end() {
		List<Matricula> list = matriculaDAO.buscarTodos();
		list.forEach(mat -> matriculaDAO.excluir(mat));
		
	}
	
	@Test
	public void cadastrar() {
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat = matriculaDAO.cadastrar(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());

	}
	
	@Test
	public void buscarTodos() {
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat = matriculaDAO.cadastrar(mat);
		
		Matricula mat1 = new Matricula();
		mat1.setCodigo("A2");
		mat1.setDataMatricula(Instant.now());
		mat1.setStatus("ATIVA");
		mat1.setValor(3000d);
		mat1 = matriculaDAO.cadastrar(mat1);
		
		List<Matricula> list = matriculaDAO.buscarTodos();
		
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void buscarPorID() {
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat = matriculaDAO.cadastrar(mat);
		assertNotNull(mat);
		
		Matricula matBD = matriculaDAO.buscarPorID(mat.getId());
		assertNotNull(matBD);
		assertEquals(mat.getId(), matBD.getId());
		
	}
	
	@Test
	public void alterar() {
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000d);
		mat = matriculaDAO.cadastrar(mat);
		
		Matricula matBD = matriculaDAO.buscarPorID(mat.getId());
		assertNotNull(matBD);
		assertEquals(mat.getId(), matBD.getId());
		
		matBD.setStatus("DESATIVADA");
		Matricula matUp = matriculaDAO.Alterar(matBD);
		assertEquals("DESATIVADA", matUp.getStatus());
	}
	
}
