package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.service.interfaces.LoanService;
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
