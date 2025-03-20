package com.example.SamplePayment.service;

@service
public class VideoProcessor {
	@Override
    public void process(OrderRequest orderRequest) {
        System.out.println("Processing video order.");
        if ("Learning to Ski".equalsIgnoreCase(orderRequest.getProductName())) {
            System.out.println("Adding free 'First Aid' video to packing slip.");
        }
    }

}
