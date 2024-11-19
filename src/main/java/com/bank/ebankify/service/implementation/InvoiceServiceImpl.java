package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.InvoiceDto;
import com.bank.ebankify.mapper.InvoiceMapper;
import com.bank.ebankify.model.Invoice;
import com.bank.ebankify.repository.InvoiceRepository;
import com.bank.ebankify.service.interfaces.InvoiceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceMapper invoiceMapper;
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDto create(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(savedInvoice);
    }

    @Override
    public Page<InvoiceDto> findAll(Pageable pageable) {
        return invoiceRepository.findAll(pageable).map(invoiceMapper::toDto);
    }

    @Override
    public Invoice findById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public InvoiceDto update(Long id, InvoiceDto invoiceDto) {
        Invoice invoice = findById(id);
        Invoice invoiceUpdate = invoiceMapper.toEntity(invoiceDto);
        invoiceUpdate.setId(invoice.getId());
        Invoice updatedInvoice = invoiceRepository.save(invoiceUpdate);
        return invoiceMapper.toDto(updatedInvoice);
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Page<InvoiceDto> findByUserId(Long userId, Pageable pageable) {
        return invoiceRepository.findByUserId(userId, pageable).map(invoiceMapper::toDto);
    }
}
