package com.bank.ebankify.controller;

import com.bank.ebankify.dto.TransactionDto;
import com.bank.ebankify.model.Transaction;
import com.bank.ebankify.service.interfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto transactiondto) {
        TransactionDto createdTransaction = transactionService.create(transactiondto);
        return ResponseEntity.ok(createdTransaction);
    }

    @GetMapping
    public ResponseEntity<Page<TransactionDto>> getAllTransactions(Pageable pageable) {
        Page<TransactionDto> transactions = transactionService.findAll(pageable);
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionDto> update(@PathVariable Long id, @RequestBody TransactionDto transactiondto) {
        TransactionDto updatedTransaction = transactionService.update(id, transactiondto);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
