package model;

import java.util.Date;

/**
 * CheckIn entity. @author MyEclipse Persistence Tools
 */

public class CheckIn implements java.io.Serializable {

	// Fields

	private String id;
	private Date inTime;
	private Date outTime;
	private String customer1;
	private String customer2;

	// Constructors

	/** default constructor */
	public CheckIn() {
	}

	/** minimal constructor */
	public CheckIn(String id) {
		this.id = id;
	}

	/** full constructor */
	public CheckIn(String id, Date inTime, Date outTime, String customer1,
			String customer2) {
		this.id = id;
		this.inTime = inTime;
		this.outTime = outTime;
		this.customer1 = customer1;
		this.customer2 = customer2;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getCustomer1() {
		return this.customer1;
	}

	public void setCustomer1(String customer1) {
		this.customer1 = customer1;
	}

	public String getCustomer2() {
		return this.customer2;
	}

	public void setCustomer2(String customer2) {
		this.customer2 = customer2;
	}

}