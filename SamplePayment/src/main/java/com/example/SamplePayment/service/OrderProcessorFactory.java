package com.example.SamplePayment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class OrderProcessorFactory {
	 private final Map<String, PaymentProcessor> processorMap = new HashMap<>();

	    public OrderProcessorFactory(ProductProcessor physicalProductProcessor,
	                                 BookProcessor bookProcessor,
	                                 MembershipProcessor membershipProcessor,
	                                 MembershipUpgradeProcessor membershipUpgradeProcessor) {
	        processorMap.put("PHYSICAL_PRODUCT", physicalProductProcessor);
	        processorMap.put("BOOK", bookProcessor);
	        processorMap.put("MEMBERSHIP", membershipProcessor);
	        processorMap.put("UPGRADE_MEMBERSHIP", membershipUpgradeProcessor);
	    }

	    public PaymentProcessor getProcessor(String orderType) {
	        return processorMap.get(orderType);
	    }

}
