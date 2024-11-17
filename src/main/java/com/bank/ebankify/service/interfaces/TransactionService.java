package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.TransactionDto;
import com.bank.ebankify.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransactionService {

    TransactionDto create(TransactionDto transactionDto);
    Page<TransactionDto> findAll(Pageable pageable);
    Transaction findById(Long id);
    TransactionDto update(Long id, TransactionDto transactionDto);
    void delete(Long id);
}
