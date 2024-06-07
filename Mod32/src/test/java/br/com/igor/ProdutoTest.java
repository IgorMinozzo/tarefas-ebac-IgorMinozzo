package br.com.igor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.igor.dao.IProdutoDAO;
import br.com.igor.dao.ProdutoDAO;
import br.com.igor.domain.Curso;
import br.com.igor.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	public ProdutoTest() {
		
		produtoDAO = new ProdutoDAO();	
	}
	
	@After
	public void end() {
		
		List<Produto> listCurso = produtoDAO.buscarTodos();
		listCurso.forEach(cur -> produtoDAO.excluir(cur));
	}
	
	@Test
	public void cadastrar() {
		Produto prod = new Produto();
		prod.setCodigo("A1");
		prod.setNome("ARROZ");
		prod.setValor(10d);
		prod = produtoDAO.cadastrar(prod);
		
		assertNotNull(prod);
		assertNotNull(prod.getId());
	}
	
	@Test
	public void buscarTodos() {
		Produto prod = new Produto();
		prod.setCodigo("A1");
		prod.setNome("TESTE");
		prod.setValor(10d);
		prod = produtoDAO.cadastrar(prod);
		
		Produto prod1 = new Produto();
		prod1.setCodigo("A2");
		prod1.setNome("TESTE 1");
		prod1.setValor(20d);
		prod1 = produtoDAO.cadastrar(prod1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
