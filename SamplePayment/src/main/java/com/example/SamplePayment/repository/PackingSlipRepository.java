package com.example.SamplePayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SamplePayment.model.PackingSlip;

public interface PackingSlipRepository extends JpaRepository<PackingSlip, Integer> 
{

}
