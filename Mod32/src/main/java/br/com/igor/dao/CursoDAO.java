package br.com.igor.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.igor.domain.Curso;

public class CursoDAO implements ICursoDAO{

	@Override
	public Curso cadastrar(Curso curso) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return curso;
	}

	@Override
	public void excluir(Curso cur) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		cur = entityManager.merge(cur);
		entityManager.remove(cur);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public List<Curso> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Curso> query = builder.createQuery(Curso.class);
		Root<Curso> root = query.from(Curso.class);
		query.select(root);
		
		TypedQuery<Curso> tpQuery = 
				entityManager.createQuery(query);
		List<Curso> list = tpQuery.getResultList();  
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

	@Override
	public Curso buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Curso curso = entityManager.find(Curso.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return curso;
	}

	@Override
	public Curso Alterar(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		curso = entityManager.merge(curso);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return curso;
	}
	
}
