package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.service.interfaces.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class LoanServiceImpl implements LoanService {
    @Override
    public LoanDto create(LoanDto loanDto) {
        return null;
    }

    @Override
    public Page<LoanDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<LoanDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public LoanDto update(Long id, LoanDto loanDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<LoanDto> findByUserId(Long userId, Pageable pageable) {
        return null;
    }
}
