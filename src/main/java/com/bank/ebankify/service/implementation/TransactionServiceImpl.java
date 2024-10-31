package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.TransactionDto;
import com.bank.ebankify.service.interfaces.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public Page<TransactionDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<TransactionDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TransactionDto update(Long id, TransactionDto transactionDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<TransactionDto> findByAccountId(Long accountId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<TransactionDto> findByRole(String role, Pageable pageable) {
        return null;
    }
}
