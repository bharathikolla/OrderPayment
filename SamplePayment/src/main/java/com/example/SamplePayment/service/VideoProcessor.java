package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class VideoProcessor implements PaymentProcessor {
    private final PackingSlipService packingSlipService;

    public VideoProcessor(PackingSlipService packingSlipService) {
        this.packingSlipService = packingSlipService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        StringBuilder packingSlip = new StringBuilder("Packing Slip for Video: " + orderRequest.getProductName());

        if ("Learning to Ski".equalsIgnoreCase(orderRequest.getProductName())) {
            packingSlip.append("\nBonus: Free 'First Aid' Video (Per 1997 court decision)");
        }

        packingSlipService.generatePackingSlip(orderRequest.getOrderId(), packingSlip.toString());
    }

}
