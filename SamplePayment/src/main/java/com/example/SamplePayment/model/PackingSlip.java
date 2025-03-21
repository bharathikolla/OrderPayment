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
public class PackingSlip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String orderId;
	private String customerEmail;
	private String shippingAddress;

	public PackingSlip() {}

	public PackingSlip(String orderId, String customerEmail, String shippingAddress) {
		this.orderId = orderId;
		this.customerEmail = customerEmail;
		this.shippingAddress = shippingAddress;
	}

}
