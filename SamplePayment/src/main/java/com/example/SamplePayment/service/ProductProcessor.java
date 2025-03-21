package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class ProductProcessor implements PaymentProcessor {
    private  PackingSlipService packingSlipService;
    private AgentCommissionService agentCommissionService;

    @Override
    public void process(OrderRequest orderRequest) {
        packingSlipService.generatePackingSlip(
                orderRequest.getId(),
                orderRequest.getEmail(),
                orderRequest.getShippingAddress()
        );
        agentCommissionService.generateCommission(orderRequest.getId(), orderRequest.getProductName(),orderRequest.getProductPrice()); 
    }
}
