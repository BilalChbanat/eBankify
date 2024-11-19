package com.bank.ebankify.services;

import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testAccountCreation() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("John Doe");

        Account account = new Account();
        account.setId(1L);
        account.setAccountNumber("123456789");
        account.setBalance(new BigDecimal("5000.00"));
        account.setOwner(user);
        account.setActive(true);

        // Assert
        assertNotNull(account);
        assertEquals(1L, account.getId());
        assertEquals("123456789", account.getAccountNumber());
        assertEquals(new BigDecimal("5000.00"), account.getBalance());
        assertEquals(user, account.getOwner());
        assertTrue(account.isActive());
    }

    @Test
    void testAccountBalanceUpdate() {
        // Arrange
        Account account = new Account();
        account.setBalance(new BigDecimal("1000.00"));

        // Act
        account.setBalance(account.getBalance().add(new BigDecimal("500.00")));

        // Assert
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
    }

    @Test
    void testAccountDeactivation() {
        // Arrange
        Account account = new Account();
        account.setActive(true);

        // Act
        account.setActive(false);

        // Assert
        assertFalse(account.isActive());
    }
}
