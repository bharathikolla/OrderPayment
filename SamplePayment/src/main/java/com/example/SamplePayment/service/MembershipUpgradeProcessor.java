package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class MembershipUpgradeProcessor implements PaymentProcessor {
    private final MembershipService membershipService;

    public MembershipUpgradeProcessor(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @Override
    public void process(OrderRequest orderRequest) {
        membershipService.upgradeMembership(orderRequest.getEmail());
    }
}
