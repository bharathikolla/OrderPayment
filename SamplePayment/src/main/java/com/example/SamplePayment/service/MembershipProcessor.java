package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;

import com.example.SamplePayment.model.OrderRequest;

@Service
public class MembershipProcessor  implements PaymentProcessor {
	private final MembershipService membershipService;

	public MembershipProcessor(MembershipService membershipService) {
		this.membershipService = membershipService;
	}

	@Override
	public void process(OrderRequest orderRequest) {
		membershipService.activateMembership(orderRequest.getEmail());
	}

}
