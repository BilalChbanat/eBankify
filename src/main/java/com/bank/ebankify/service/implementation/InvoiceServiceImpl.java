package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.InvoiceDto;
import com.bank.ebankify.service.interfaces.InvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public InvoiceDto create(InvoiceDto invoiceDto) {
        return null;
    }

    @Override
    public Page<InvoiceDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<InvoiceDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public InvoiceDto update(Long id, InvoiceDto invoiceDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<InvoiceDto> findByUserId(Long userId, Pageable pageable) {
        return null;
    }
}
