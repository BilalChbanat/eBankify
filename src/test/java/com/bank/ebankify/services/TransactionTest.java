package com.bank.ebankify.services;

import com.bank.ebankify.enums.TransactionStatusEnum;
import com.bank.ebankify.enums.TransactionTypeEnum;
import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    void testTransactionCreation() {
        // Arrange
        Account accountFrom = new Account();
        accountFrom.setId(1L);
        accountFrom.setAccountNumber("123456789");

        Account accountTo = new Account();
        accountTo.setId(2L);
        accountTo.setAccountNumber("987654321");

        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setType(TransactionTypeEnum.INSTANT);
        transaction.setAmount(500.0);
        transaction.setDate(LocalDate.now());
        transaction.setAccountFrom(accountFrom);
        transaction.setAccountTo(accountTo);
        transaction.setFee(5.0);
        transaction.setStatus(TransactionStatusEnum.PENDING);

        // Assert
        assertNotNull(transaction);
        assertEquals(1L, transaction.getId());
        assertEquals(TransactionTypeEnum.INSTANT, transaction.getType());
        assertEquals(500.0, transaction.getAmount());
        assertEquals(LocalDate.now(), transaction.getDate());
        assertEquals(accountFrom, transaction.getAccountFrom());
        assertEquals(accountTo, transaction.getAccountTo());
        assertEquals(5.0, transaction.getFee());
        assertEquals(TransactionStatusEnum.PENDING, transaction.getStatus());
    }

    @Test
    void testTransactionFeeCalculation() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(1000.0);

        // Act
        double fee = transaction.getAmount() * 0.02; // 2% fee
        transaction.setFee(fee);

        // Assert
        assertEquals(20.0, transaction.getFee());
    }

    @Test
    void testTransactionStatusUpdate() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setStatus(TransactionStatusEnum.PENDING);

        // Act
        transaction.setStatus(TransactionStatusEnum.APPROVED);

        // Assert
        assertEquals(TransactionStatusEnum.APPROVED, transaction.getStatus());
    }
}
