package com.example.SamplePayment.service;

import com.example.SamplePayment.model.OrderRequest;

public interface PaymentProcessor {

	 void process(OrderRequest orderRequest);
}
