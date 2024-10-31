package com.bank.ebankify.repository;

import com.bank.ebankify.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findAll(Pageable pageable);
    Optional<Transaction> findById(Long id);
    Page<Transaction> findByStatus(String status, Pageable pageable);
    Page<Transaction> findByType(String type, Pageable pageable);
    Page<Transaction> findByAccountFromIdOrAccountToId(Long accountId, Long accountIdTo, Pageable pageable);
}
