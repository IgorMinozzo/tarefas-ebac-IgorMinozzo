package br.com.igor.dao;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.igor.domain.Cliente;
import br.com.igor.domain.Produto;
import br.com.igor.domain.Venda;
import br.com.igor.exceptions.DAOException;
import br.com.igor.exceptions.TipoChaveNaoEncontradaException;
import br.com.igor.generic.GenericDAO;
import br.com.igor.generic.GenericDB1DAO;

public class VendaDAO extends GenericDB1DAO<Venda, Long> implements IVendaDAO{

	
	
	public VendaDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);		
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);		
	}

	@Override
	public Venda consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery = 
				entityManager.createQuery(query);
		Venda venda = tpQuery.getSingleResult();   
		closeConnection();
		return venda;
	}
	
	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			openConnection();
			entity.getProdutos().forEach(prod -> {
				Produto prodJpa = entityManager.merge(prod.getProduto());
				prod.setProduto(prodJpa);
			});
			Cliente cliente = entityManager.merge(entity.getCliente());
			entity.setCliente(cliente);
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			closeConnection();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

}
