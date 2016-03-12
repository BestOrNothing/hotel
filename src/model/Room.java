package model;

import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields

	private String id;
	private String type;
	private Integer price;
	private Set users;

	// Constructors

	public Set getUsers() {
		return users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	/** default constructor */
	public Room() {
	}

	/** minimal constructor */
	public Room(String id) {
		this.id = id;
	}

	/** full constructor */
	public Room(String id, String type, Integer price) {
		this.id = id;
		this.type = type;
		this.price = price;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}