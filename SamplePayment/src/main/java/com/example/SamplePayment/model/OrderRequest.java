package com.example.SamplePayment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
	
	 private Integer id;
	 private String productName;
	 private OrderType orderType;
	 private String email;
	 private String shippingAddress;
	 private String productPrice;
}
