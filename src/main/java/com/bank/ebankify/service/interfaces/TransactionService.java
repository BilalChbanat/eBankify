package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.TransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransactionService {

    TransactionDto create(TransactionDto transactionDto);
    Page<TransactionDto> findAll(Pageable pageable);
    Optional<TransactionDto> findById(Long id);
    TransactionDto update(Long id, TransactionDto transactionDto);
    void delete(Long id);
    Page<TransactionDto> findByAccountId(Long accountId, Pageable pageable);
    Page<TransactionDto> findByRole(String role, Pageable pageable);
}
