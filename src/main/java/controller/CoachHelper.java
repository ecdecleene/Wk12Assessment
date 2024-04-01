package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Coach;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 19, 2024  
*/
public class CoachHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk06Assessment");

	public void insertCoach(Coach c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Coach> showAllCoaches(){
		EntityManager em = emfactory.createEntityManager();
		List<Coach> allCoaches = em.createQuery("SELECT c from Coach c").getResultList();
		return allCoaches;
	}
	
	public Coach findCoach(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coach> typedQuery = em.createQuery("select ch from Coach ch where ch.coachName = :selectedName",Coach.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Coach foundCoach;
		try {
			foundCoach = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCoach = new Coach(nameToLookUp);
		}
		em.close();

		return foundCoach;
	}
}
