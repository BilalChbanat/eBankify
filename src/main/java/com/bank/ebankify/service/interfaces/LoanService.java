package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.model.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoanService {
    LoanDto create(LoanDto loanDto);
    Page<LoanDto> findAll(Pageable pageable);
    Loan findById(Long id);
    LoanDto update(Long id, LoanDto loanDto);
    void delete(Long id);
    Page<LoanDto> findByUserId(Long userId, Pageable pageable);
}
