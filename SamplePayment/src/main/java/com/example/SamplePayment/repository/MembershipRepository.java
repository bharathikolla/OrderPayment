package com.example.SamplePayment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SamplePayment.model.Membership;

public interface MembershipRepository  extends JpaRepository<Membership, Integer>
{
	Optional<Membership> findByEmail(String email);

}
