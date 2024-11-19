package com.bank.ebankify.controller;


import com.bank.ebankify.dto.InvoiceDto;
import com.bank.ebankify.service.interfaces.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/save")
    public ResponseEntity<InvoiceDto> create(@RequestBody InvoiceDto invoiceDto) {
        InvoiceDto createdInvoice = invoiceService.create(invoiceDto);
        return ResponseEntity.ok(createdInvoice);
    }

    @GetMapping
    public ResponseEntity<Page<InvoiceDto>> getAllInvoices(Pageable pageable) {
        Page<InvoiceDto> invoices = invoiceService.findAll(pageable);
        return ResponseEntity.ok(invoices);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<InvoiceDto> update(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) {
        InvoiceDto updatedInvoice = invoiceService.update(id, invoiceDto);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
