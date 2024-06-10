package br.com.igor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.igor.domain.Aluno;


public class AlunoDAO implements IAlunoDAO{

	@Override
	public Aluno cadastrar(Aluno aluno) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(aluno);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return aluno;
	}

	@Override
	public void excluir(Aluno aluno) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		aluno = entityManager.merge(aluno);
		entityManager.remove(aluno);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
	}

	@Override
	public List<Aluno> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Aluno> query = builder.createQuery(Aluno.class);
		Root<Aluno> root = query.from(Aluno.class);
		query.select(root);
		
		TypedQuery<Aluno> tpQuery = 
				entityManager.createQuery(query);
		List<Aluno> list = tpQuery.getResultList();  
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

	@Override
	public Aluno buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Aluno aluno = entityManager.find(Aluno.class, id);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return aluno;
	}

	@Override
	public Aluno Alterar(Aluno aluno) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		aluno = entityManager.merge(aluno);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return aluno;
	}

}
