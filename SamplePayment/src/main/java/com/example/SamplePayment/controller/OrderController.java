package com.example.SamplePayment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SamplePayment.model.OrderRequest;
import com.example.SamplePayment.service.PaymentProcessor;
import com.example.SamplePayment.service.PaymentProcessorFactory;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	private final PaymentProcessorFactory processorFactory;

	public OrderController(PaymentProcessorFactory processorFactory)
	{
		this.processorFactory = processorFactory;
	}

	@PostMapping("/process")
	public String processOrder(@RequestBody OrderRequest orderRequest) 
	{
		PaymentProcessor processor = processorFactory.getProcessor(orderRequest.getOrderType());
		if (processor != null)
		{
			processor.process(orderRequest);
			return "Order processed successfully.";
		} 
		else 
		{
			return "Invalid order type.";
		}
	}
}
