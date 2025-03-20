package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class BookProcessor implements PaymentProcessor {
    private final PackingSlipService packingSlipService;

    public BookProcessor(PackingSlipService packingSlipService) {
        this.packingSlipService = packingSlipService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        packingSlipService.generatePackingSlipForBook(
                orderRequest.getOrderId(),
                orderRequest.getEmail(),
                orderRequest.getShippingAddress()
        );
    }
}
