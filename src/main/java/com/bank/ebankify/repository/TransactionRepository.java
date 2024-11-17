package com.bank.ebankify.repository;

import com.bank.ebankify.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findTransactionsByStatus(String status, Pageable pageable);
    Page<Transaction> findTransactionsByType(String type, Pageable pageable);
}
