package com.example.SamplePayment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
