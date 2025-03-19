package com.example.SamplePayment.service;

import com.example.SamplePayment.model.OrderRequest;

@service
public class ProductProcessor {
	
	@Override
    public void process(OrderRequest orderRequest)
	{
        System.out.println("Generating packing slip for shipping.");
        System.out.println("Commission payment generated for agent.");
    }
}
