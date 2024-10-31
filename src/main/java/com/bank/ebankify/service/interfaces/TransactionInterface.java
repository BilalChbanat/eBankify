package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.TransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TransactionInterface {

    TransactionDto create(TransactionDto transactionDto);
    Page<TransactionDto> findAll(Pageable pageable);
    Optional<TransactionDto> findById(Long id);
    TransactionDto update(Long id, TransactionDto transactionDto);
    Page<TransactionDto> findByStatus(String status, Pageable pageable);
    Page<TransactionDto> findByType(String type, Pageable pageable);
    Page<TransactionDto> findByAccountId(Long accountId, Pageable pageable);
}
