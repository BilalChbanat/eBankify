package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.InvoiceDto;
import com.bank.ebankify.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InvoiceService {
    InvoiceDto create(InvoiceDto invoiceDto);
    Page<InvoiceDto> findAll(Pageable pageable);
    Invoice findById(Long id);
    InvoiceDto update(Long id, InvoiceDto invoiceDto);
    void delete(Long id);
    Page<InvoiceDto> findByUserId(Long userId, Pageable pageable);
}
