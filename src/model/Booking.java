package model;

import java.util.Date;

/**
 * Booking entity. @author MyEclipse Persistence Tools
 */

public class Booking implements java.io.Serializable {

	// Fields

	private BookingId id;
	private Date outTime;

	// Constructors

	/** default constructor */
	public Booking() {
	}

	/** full constructor */
	public Booking(BookingId id, Date outTime) {
		this.id = id;
		this.outTime = outTime;
	}

	// Property accessors

	public BookingId getId() {
		return this.id;
	}

	public void setId(BookingId id) {
		this.id = id;
	}

	public Date getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

}