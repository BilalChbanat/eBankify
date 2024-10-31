package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.LoanDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoanInterface {

    LoanDto create(LoanDto loanDto);
    Page<LoanDto> findAll(Pageable pageable);
    Optional<LoanDto> findById(Long id);
    LoanDto update(Long id, LoanDto loanDto);
    void delete(Long id);
    Page<LoanDto> findByStatus(String status, Pageable pageable);
    Page<LoanDto> findByUserId(Long userId, Pageable pageable);
}
