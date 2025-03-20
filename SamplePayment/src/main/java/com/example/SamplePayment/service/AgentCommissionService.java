package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

@Service
public class AgentCommissionService {
	
	
	public void generateCommission(String orderId, String productName, double amount) {
        double commissionPercentage = 0.10;
        double commissionAmount = amount * commissionPercentage;

        System.out.println("Commission Generated for Order ID: " + orderId);
        System.out.println("Product: " + productName);
        System.out.println("Commission Amount: $" + commissionAmount);
    }

}
