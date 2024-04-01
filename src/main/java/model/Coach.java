package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 18, 2024  
*/
@Entity
@Table(name="coach")
public class Coach {
	@Id
	@GeneratedValue
	private int id;
	private String coachName;
	
	public Coach() {
		super();
	}
	
	/**
	 * @param coachName
	 */
	public Coach(String coachName) {
		super();
		this.coachName = coachName;
	}

	/**
	 * @param id
	 * @param coachName
	 */
	public Coach(int id, String coachName) {
		super();
		this.id = id;
		this.coachName = coachName;
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
	 * @return the coachName
	 */
	public String getCoachName() {
		return coachName;
	}
	/**
	 * @param coachName the coachName to set
	 */
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
}
