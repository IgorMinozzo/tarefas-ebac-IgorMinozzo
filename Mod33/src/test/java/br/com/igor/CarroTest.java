package br.com.igor;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.igor.dao.AcessorioDAO;
import br.com.igor.dao.CarroDAO;
import br.com.igor.dao.IAcessorioDAO;
import br.com.igor.dao.ICarroDAO;
import br.com.igor.dao.IMarcaDAO;
import br.com.igor.dao.MarcaDAO;
import br.com.igor.domain.Acessorio;
import br.com.igor.domain.Carro;
import br.com.igor.domain.Marca;

public class CarroTest {
	
	private ICarroDAO carroDAO;
	
	private IMarcaDAO marcaDAO;
	
	private IAcessorioDAO acessorioDAO;
	
	public CarroTest() {
		
		carroDAO = new CarroDAO();
		
		marcaDAO = new MarcaDAO();
		
		acessorioDAO = new AcessorioDAO();
	}
	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setNome("Santana");
		carro.setValor(20000d);
		Marca marca = criarMarca("A1");
		Acessorio acessorio = criarAcessorio("A1");
		carro.setMarca(marca);
		carro.setAcessorio(acessorio);
		carro = carroDAO.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
		
	}

	private Acessorio criarAcessorio(String codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setNome("Direcao Hidraulica");
		acessorio.setCodigo(codigo);
		return acessorioDAO.cadastrar(acessorio);
	}
	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setNome("Volkswagen");
		marca.setCodigo(codigo);
		return marcaDAO.cadastrar(marca);
	}
	
	
}
