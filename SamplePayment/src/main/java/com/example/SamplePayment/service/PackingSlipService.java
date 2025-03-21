package com.example.SamplePayment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SamplePayment.model.PackingSlip;
import com.example.SamplePayment.repository.PackingSlipRepository;

@Service
public class PackingSlipService 
{
	private static final String ROYALTY_DEPARTMENT_ADDRESS = "Royalty Department, 456 Publisher St, City, Country";
	private final PackingSlipRepository packingSlipRepository;

	public PackingSlipService(PackingSlipRepository packingSlipRepository) 
	{
		this.packingSlipRepository = packingSlipRepository;
	}

	@Transactional
	public void generatePackingSlip(String orderId, String customerEmail, String shippingAddress) {
		PackingSlip packingSlip = new PackingSlip(orderId, customerEmail, shippingAddress);
		packingSlipRepository.save(packingSlip);
	}
	@Transactional
	public void generatePackingSlipForBook(String orderId, String customerEmail, String shippingAddress) {
		// Generate normal packing slip
		generatePackingSlip(orderId, customerEmail, shippingAddress);

		// Generate duplicate packing slip for the Royalty Department
		generatePackingSlip(orderId, "royalty@publisher.com", ROYALTY_DEPARTMENT_ADDRESS);
	}
}

