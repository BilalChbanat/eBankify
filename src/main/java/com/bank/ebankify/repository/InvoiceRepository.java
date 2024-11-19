package com.bank.ebankify.repository;

import com.bank.ebankify.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Page<Invoice> findInvoiceByStatus(String status, Pageable pageable);
    Page<Invoice> findByUserId(Long userId, Pageable pageable);
}
