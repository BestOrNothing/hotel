package model;

import java.util.Date;

/**
 * BookingId entity. @author MyEclipse Persistence Tools
 */

public class BookingId implements java.io.Serializable {

	// Fields

	private String username;
	private String id;
	private Date inTime;

	// Constructors

	/** default constructor */
	public BookingId() {
	}

	/** full constructor */
	public BookingId(String username, String id, Date inTime) {
		this.username = username;
		this.id = id;
		this.inTime = inTime;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BookingId))
			return false;
		BookingId castOther = (BookingId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getInTime() == castOther.getInTime()) || (this
						.getInTime() != null && castOther.getInTime() != null && this
						.getInTime().equals(castOther.getInTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getInTime() == null ? 0 : this.getInTime().hashCode());
		return result;
	}

}