package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Jan 31, 2024  
*/
@Entity
@Table(name="uniforms")
public class PlayerUniform {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NUMBER")
	private int number;
	@Column(name="NAME")
	private String name;
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
	 * @return the num
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param num the num to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param num
	 * @param name
	 */
	public PlayerUniform(int num, String name) {
		super();
		this.number = num;
		this.name = name;
	}
	
	public PlayerUniform() {
		
	}
	
	public String returnUniformDetails() {
		String string = this.name + " -- " + this.number;
		return string;
	}
}
