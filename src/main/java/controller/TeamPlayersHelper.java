package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.TeamPlayers;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 19, 2024  
*/
public class TeamPlayersHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Wk06Assessment");
	
	public void insertNewTeamPlayers(TeamPlayers t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<TeamPlayers> getTeams(){
		EntityManager em = emfactory.createEntityManager();
		List<TeamPlayers> allPlayers = em.createQuery("SELECT t FROM TeamPlayers t").getResultList();
		return allPlayers;
	}
	
	public void deleteTeam(TeamPlayers toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<TeamPlayers> typedQuery = em.createQuery("select player from TeamPlayers player where player.id = :selectedId", TeamPlayers.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		TeamPlayers result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public TeamPlayers searchForTeamById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TeamPlayers found = em.find(TeamPlayers.class, tempId);
		em.close();
		return found;
	}
	
	public void updateTeam(TeamPlayers toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
