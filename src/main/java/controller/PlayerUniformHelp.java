package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.PlayerUniform;

/**
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 1, 2024
*/
public class PlayerUniformHelp {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk06Assessment");
	
	public void insertUniform(PlayerUniform li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PlayerUniform> showAllUniforms(){
		EntityManager em = emfactory.createEntityManager();
		List<PlayerUniform> allUniforms = em.createQuery("SELECT i FROM PlayerUniform i").getResultList();
		return allUniforms;
	}
	
	public void deleteUniform(PlayerUniform toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from "
				+ "PlayerUniform li where li.name = :selectedName and li.number = :selectedNumber", PlayerUniform.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedNumber",
		toDelete.getNumber());
		typedQuery.setMaxResults(1);
		PlayerUniform result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
	public void updateUniform(PlayerUniform toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public PlayerUniform searchForUniformById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PlayerUniform found = em.find(PlayerUniform.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<PlayerUniform> searchForUniformByName(String nameN) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from PlayerUniform li where li.name = :selectedName",
				PlayerUniform.class);
		typedQuery.setParameter("selectedName", nameN);
		List<PlayerUniform> foundNumbers = typedQuery.getResultList();
		em.close();
		return foundNumbers;
	}

	public List<PlayerUniform> searchForUniformByNumber(String numberN) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PlayerUniform> typedQuery = em.createQuery("select li from PlayerUniform li where li.number = :selectedNumber",
				PlayerUniform.class);
		typedQuery.setParameter("selectedUniform", numberN);
		List<PlayerUniform> foundNumbers = typedQuery.getResultList();
		em.close();
		return foundNumbers;
	}
}
