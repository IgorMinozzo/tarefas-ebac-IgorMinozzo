package br.com.igor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import br.com.igor.domain.Computador;

public class ComputadorDAO implements IComputadorDAO{

	@Override
	public Computador cadastrar(Computador comp) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(comp);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return comp;
	}

	@Override
	public void excluir(Computador comp) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		comp = entityManager.merge(comp);
		entityManager.remove(comp);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public List<Computador> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Computador> query = builder.createQuery(Computador.class);
		Root<Computador> root = query.from(Computador.class);
		query.select(root);
		
		TypedQuery<Computador> tpQuery = 
				entityManager.createQuery(query);
		List<Computador> list = tpQuery.getResultList();  
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

	@Override
	public Computador buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Computador comp = entityManager.find(Computador.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return comp;
	}

	@Override
	public Computador Alterar(Computador comp) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		comp = entityManager.merge(comp);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return comp;
	}

}
