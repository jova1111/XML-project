package com.otkudznam.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Reservations {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	

	@ManyToOne
	protected Lodging Lodging;
	

	@OneToOne
	protected Period Period;

	@ManyToOne
	protected User User;
	
	protected boolean Activated;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lodging getLodging() {
		return Lodging;
	}

	public void setLodging(Lodging lodging) {
		Lodging = lodging;
	}

	public Period getPeriod() {
		return Period;
	}

	public void setPeriod(Period period) {
		Period = period;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		this.User = user;
	}

	public boolean getActivated() {
		return Activated;
	}

	public void setActivated(boolean activated) {
		Activated = activated;
	}
	
	
	
	
	
	
}
