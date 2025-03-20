package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class ProductProcessor implements PaymentProcessor {
    private final PackingSlipService packingSlipService;

    public PhysicalProductProcessor(PackingSlipService packingSlipService) {
        this.packingSlipService = packingSlipService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        packingSlipService.generatePackingSlip(
                orderRequest.getOrderId(),
                orderRequest.getEmail(),
                orderRequest.getShippingAddress()
        );
    }
}
