package com.bank.ebankify.repository;

import com.bank.ebankify.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Page<Loan> findByStatus(String status, Pageable pageable);
    Page<Loan> findByUserId(Long userId, Pageable pageable);
}
