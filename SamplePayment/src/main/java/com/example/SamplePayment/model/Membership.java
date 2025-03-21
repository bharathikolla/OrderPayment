package com.example.SamplePayment.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Membership 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String  email;
	private boolean isActive;
	private boolean isUpgraded;

	public Membership()
	{

	}

	public Membership(String email, boolean isActive,boolean isUpgraded) {
		this.email = email;
		this.isActive = isActive;
		this.isUpgraded = isUpgraded;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isUpgraded() {
		return isUpgraded;
	}

	public void setUpgraded(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
	}
	
}
