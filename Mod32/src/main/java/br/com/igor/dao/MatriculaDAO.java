package br.com.igor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.igor.domain.Curso;
import br.com.igor.domain.Matricula;

public class MatriculaDAO implements IMatriculaDAO {

	@Override
	public Matricula cadastrar(Matricula mat) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(mat);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return mat;
	}

	@Override
	public void excluir(Matricula matricula) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		matricula = entityManager.merge(matricula);
		entityManager.remove(matricula);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();	
	}

	@Override
	public List<Matricula> buscarTodos() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
		Root<Matricula> root = query.from(Matricula.class);
		query.select(root);
		
		TypedQuery<Matricula> tpQuery = 
				entityManager.createQuery(query);
		List<Matricula> list = tpQuery.getResultList();  
		
		entityManager.close();
		entityManagerFactory.close();
		return list;
	}

	@Override
	public Matricula buscarPorID(Long id) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		entityManager.getTransaction().begin();
		Matricula matricula = entityManager.find(Matricula.class, id);
		entityManager.getTransaction().commit();
			
		entityManager.close();
		entityManagerFactory.close();
			
		return matricula;
	
	}

	@Override
	public Matricula Alterar(Matricula mat) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("Mod32");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		mat = entityManager.merge(mat);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return mat;
	}

}
