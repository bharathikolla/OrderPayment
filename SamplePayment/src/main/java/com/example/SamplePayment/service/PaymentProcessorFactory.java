package com.example.SamplePayment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderType;

@Service
public class PaymentProcessorFactory {

	private final Map<OrderType, PaymentProcessor> processors;

	public PaymentProcessorFactory(ProductProcessor productProcessor,BookProcessor bookProcessor,MembershipProcessor membershipProcessor,MembershipUpgradeProcessor membershipUpgradeProcessor,VideoProcessor videoProcessor) 
	{
		processors = new HashMap<>();
		processors.put(OrderType.PRODUCT, productProcessor);
		processors.put(OrderType.BOOK, bookProcessor);
		processors.put(OrderType.MEMBERSHIP, membershipProcessor);
		processors.put(OrderType.MEMBERSHIP_UPGRADE, membershipUpgradeProcessor);
		processors.put(OrderType.VIDEO, videoProcessor);
	}

	public PaymentProcessor getProcessor(OrderType orderType) {
		return processors.get(orderType);
	}
}
