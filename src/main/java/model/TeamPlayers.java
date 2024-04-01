package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 18, 2024  
*/
@Entity
public class TeamPlayers {
	@Id
	@GeneratedValue
	private int id;
	private String teamName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Coach coach;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<PlayerUniform> teamPlayers;
	
	
	/**
	 * @param teamName
	 * @param coach
	 */
	public TeamPlayers(String teamName, Coach coach) {
		super();
		this.teamName = teamName;
		this.coach = coach;
	}
	/**
	 * @param teamName
	 * @param coach
	 * @param teamPlayers
	 */
	public TeamPlayers(String teamName, Coach coach, List<PlayerUniform> teamPlayers) {
		super();
		this.teamName = teamName;
		this.coach = coach;
		this.teamPlayers = teamPlayers;
	}
	/**
	 * @param id
	 * @param teamName
	 * @param coach
	 * @param teamPlayers
	 */
	public TeamPlayers(int id, String teamName, Coach coach, List<PlayerUniform> teamPlayers) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.coach = coach;
		this.teamPlayers = teamPlayers;
	}
	/**
	 * 
	 */
	public TeamPlayers() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	/**
	 * @return the coach
	 */
	public Coach getCoach() {
		return coach;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	/**
	 * @return the teamPlayers
	 */
	public List<PlayerUniform> getTeamPlayers() {
		return teamPlayers;
	}
	/**
	 * @param teamPlayers the teamPlayers to set
	 */
	public void setTeamPlayers(List<PlayerUniform> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	
}
