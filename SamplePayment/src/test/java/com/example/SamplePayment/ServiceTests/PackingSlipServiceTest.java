package com.example.SamplePayment.ServiceTests;

import com.example.SamplePayment.model.PackingSlip;
import com.example.SamplePayment.repository.PackingSlipRepository;
import com.example.SamplePayment.service.PackingSlipService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PackingSlipServiceTest {

    @Mock
    private PackingSlipRepository packingSlipRepository;

    @InjectMocks
    private PackingSlipService packingSlipService;

    private final String orderId = "ORDER123";
    private final String customerEmail = "customer@example.com";
    private final String shippingAddress = "123 Street, City, Country";
    private final String royaltyDepartmentEmail = "royalty@publisher.com";
    private final String royaltyDepartmentAddress = "Royalty Department, 456 Publisher St, City, Country";

    @BeforeEach
    void setUp() {
        packingSlipService = new PackingSlipService(packingSlipRepository);
    }

    @Test
    void testGeneratePackingSlip_SavesPackingSlipCorrectly() {
        // Act
        packingSlipService.generatePackingSlip(orderId, customerEmail, shippingAddress);

        // Assert
        ArgumentCaptor<PackingSlip> captor = ArgumentCaptor.forClass(PackingSlip.class);
        verify(packingSlipRepository, times(1)).save(captor.capture());

        PackingSlip savedSlip = captor.getValue();
        assertEquals(orderId, savedSlip.getOrderId());
        assertEquals(customerEmail, savedSlip.getCustomerEmail());
        assertEquals(shippingAddress, savedSlip.getShippingAddress());
    }

    @Test
    void testGeneratePackingSlipForBook_SavesBothPackingSlips() {
        // Act
        packingSlipService.generatePackingSlipForBook(orderId, customerEmail, shippingAddress);

        // Assert
        ArgumentCaptor<PackingSlip> captor = ArgumentCaptor.forClass(PackingSlip.class);
        verify(packingSlipRepository, times(2)).save(captor.capture());

        // First Packing Slip - Normal customer
        PackingSlip firstSlip = captor.getAllValues().get(0);
        assertEquals(orderId, firstSlip.getOrderId());
        assertEquals(customerEmail, firstSlip.getEmail());
        assertEquals(shippingAddress, firstSlip.getShippingAddress());

        // Second Packing Slip - Royalty Department
        PackingSlip secondSlip = captor.getAllValues().get(1);
        assertEquals(orderId, secondSlip.getOrderId());
        assertEquals(royaltyDepartmentEmail, secondSlip.getEmail());
        assertEquals(royaltyDepartmentAddress, secondSlip.getShippingAddress());
    }
}
