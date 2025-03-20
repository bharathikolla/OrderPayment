package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SamplePayment.model.Membership;
import com.example.SamplePayment.repository.MembershipRepository;



@Service
public class MembershipService {
	 private final MembershipRepository membershipRepository;

	 private final EmailService emailService;

	    public MembershipProcessor(EmailService emailService) {
	        this.emailService = emailService;
	    }
	    public MembershipService(MembershipRepository membershipRepository) {
	        this.membershipRepository = membershipRepository;
	    }

	    @Transactional
	    public void activateMembership(String email) {
	        Membership membership = membershipRepository.findByCustomerEmail(email)
	                .orElse(new Membership(email, false));

	        if (!membership.isActive()) {
	            membership.setActive(true);
	            membershipRepository.save(membership);
	        }
	        String subject = "Membership Activated!";
	        String message = "Dear Customer, your membership has been successfully activated.";
	        
	        emailService.sendEmail(email, subject, message);
	    }
	    
	    @Transactional
	    public void upgradeMembership(String email) {
	        Membership membership = membershipRepository.findByCustomerEmail(email)
	                .orElseThrow(() -> new RuntimeException("Membership not found for email: " + email));

	        if (!membership.isUpgraded()) {
	            membership.setUpgraded(true);
	            membershipRepository.save(membership);
	        }
	        String subject = "Membership Upgrade Successful!";
	        String message = "Dear Customer, your membership has been successfully upgraded.";
	        
	        
	        emailService.sendEmail(email, subject, message);
	    }
}
