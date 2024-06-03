package br.com.igor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.igor.dao.IProdutoDAO;
import br.com.igor.dao.ProdutoDAO;
import br.com.igor.domain.Produto;

public class ProdutoTest {
	
	private IProdutoDAO produtoDAO;
	
	@Test
	public void cadastrarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("pao");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("10");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("pao");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("10");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void excluirTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("pao");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("10");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		Integer countDel = produtoDAO.excluir(produtoBD);
		assertTrue(countDel == 1);
	}
	
	@Test
	public void buscarTodosTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("pao");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtos = new Produto();
		produtos.setCodigo("20");
		produtos.setNome("Teste");
		Integer countCad2 = produtoDAO.cadastrar(produtos);
		assertTrue(countCad2 == 1);
		
		List<Produto> list = produtoDAO.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());
		
		int countDel = 0;
		for (Produto pro : list) {
			produtoDAO.excluir(pro);
			countDel++;
		}
		assertEquals(list.size(), countDel);
		
		list = produtoDAO.buscarTodos();
		assertEquals(list.size(), 0);
		
	}
	
	@Test
	public void atualizarTest() throws Exception {
		produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setCodigo("10");
		produto.setNome("pao");
		Integer countCad = produtoDAO.cadastrar(produto);
		assertTrue(countCad == 1);
		
		Produto produtoBD = produtoDAO.buscar("10");
		assertNotNull(produtoBD);
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		
		produtoBD.setCodigo("20");
		produtoBD.setNome("arroz");
		Integer countUpdate = produtoDAO.atualizar(produtoBD);
		assertTrue(countUpdate == 1);
		
		Produto produtoBD1 = produtoDAO.buscar("10");
		assertNull(produtoBD1);
		
		Produto produtoBD2 = produtoDAO.buscar("20");
		assertNotNull(produtoBD2);
		assertEquals(produtoBD.getId(), produtoBD2.getId());
		assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
		assertEquals(produtoBD.getNome(), produtoBD2.getNome());
		
		List<Produto> list = produtoDAO.buscarTodos();
		for (Produto pro : list) {
			produtoDAO.excluir(pro);
		}
	}
}
