package com.example.SamplePayment.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderType;

@Service
public class PaymentProcessorFactory {

	private final Map<OrderType, PaymentProcessor> processors;

    public PaymentProcessorFactory(
            ProductProcessor productProcessor,
            BookProcessor bookProcessor,
            MembershipProcessor membershipProcessor,
            MembershipUpgradeProcessor membershipUpgradeProcessor,
            VideoProcessor videoProcessor) {
        
        processors = Map.of(
                OrderType.PRODUCT,productProcessor,
                OrderType.BOOK, bookProcessor,
                OrderType.MEMBERSHIP, membershipProcessor,
                OrderType.MEMBERSHIP_UPGRADE, membershipUpgradeProcessor,
                OrderType.VIDEO, videoProcessor
        );
    }

    public PaymentProcessor getProcessor(OrderType orderType) {
        return processors.get(orderType);
    }
}
