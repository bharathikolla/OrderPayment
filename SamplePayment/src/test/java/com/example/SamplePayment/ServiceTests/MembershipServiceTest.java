package com.example.SamplePayment.ServiceTests;

import com.example.SamplePayment.model.Membership;
import com.example.SamplePayment.repository.MembershipRepository;
import com.example.SamplePayment.service.EmailService;
import com.example.SamplePayment.service.MembershipService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MembershipServiceTest {

    @Mock
    private MembershipRepository membershipRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private MembershipService membershipService;

    private final String customerEmail = "test@example.com";

    @BeforeEach
    void setUp() {
        membershipService = new MembershipService(membershipRepository, emailService);
    }

    @Test
    void testActivateMembership_WhenNotActive_ShouldActivateAndSendEmail() {
        // Arrange
        Membership inactiveMembership = new Membership(customerEmail, false,false);
        when(membershipRepository.findByEmail(customerEmail)).thenReturn(Optional.of(inactiveMembership));

        // Act
        membershipService.activateMembership(customerEmail);

        // Assert
        assertTrue(inactiveMembership.isActive());
        verify(membershipRepository, times(1)).save(inactiveMembership);
        verify(emailService, times(1)).sendEmail(eq(customerEmail), anyString(), anyString());
    }

    @Test
    void testActivateMembership_WhenAlreadyActive_ShouldNotSendEmail() {
        // Arrange
        Membership activeMembership = new Membership(customerEmail, true,true);
        when(membershipRepository.findByEmail(customerEmail)).thenReturn(Optional.of(activeMembership));

        // Act
        membershipService.activateMembership(customerEmail);

        // Assert
        assertTrue(activeMembership.isActive());
        verify(membershipRepository, never()).save(any());
        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    void testUpgradeMembership_WhenNotUpgraded_ShouldUpgradeAndSendEmail() {
        // Arrange
        Membership membership = new Membership(customerEmail, false,false);
        when(membershipRepository.findByEmail(customerEmail)).thenReturn(Optional.of(membership));

        // Act
        membershipService.upgradeMembership(customerEmail);

        // Assert
        assertTrue(membership.isUpgraded());
        verify(membershipRepository, times(1)).save(membership);
        verify(emailService, times(1)).sendEmail(eq(customerEmail), anyString(), anyString());
    }

    @Test
    void testUpgradeMembership_WhenAlreadyUpgraded_ShouldNotSendEmail() {
        // Arrange
        Membership upgradedMembership = new Membership(customerEmail, true,true);
        when(membershipRepository.findByEmail(customerEmail)).thenReturn(Optional.of(upgradedMembership));

        // Act
        membershipService.upgradeMembership(customerEmail);

        // Assert
        assertTrue(upgradedMembership.isUpgraded());
        verify(membershipRepository, never()).save(any());
        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
    }

    @Test
    void testUpgradeMembership_WhenMembershipNotFound_ShouldThrowException() {
        // Arrange
        when(membershipRepository.findByEmail(customerEmail)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> membershipService.upgradeMembership(customerEmail));
        assertEquals("Membership not found for email: " + customerEmail, exception.getMessage());

        verify(membershipRepository, never()).save(any());
        verify(emailService, never()).sendEmail(anyString(), anyString(), anyString());
    }
}
