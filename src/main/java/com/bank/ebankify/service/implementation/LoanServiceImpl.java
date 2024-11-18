package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.mapper.LoanMapper;
import com.bank.ebankify.model.Loan;
import com.bank.ebankify.model.User;
import com.bank.ebankify.repository.LoanRepository;
import com.bank.ebankify.repository.UserRepository;
import com.bank.ebankify.service.interfaces.LoanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    private final UserRepository userRepository;

    @Override
    public LoanDto create(LoanDto loanDto) {
        User user = userRepository.findById(loanDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Loan loan = loanMapper.toEntity(loanDto);

        loan.setUser(user);

        Loan savedLoan = loanRepository.save(loan);
        return loanMapper.toDto(savedLoan);
    }


    @Override
    public Page<LoanDto> findAll(Pageable pageable) {
        Page<Loan> loans = loanRepository.findAll(pageable);
        return loans.map(loanMapper::toDto);
    }

    @Override
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    @Override
    public LoanDto update(Long id, LoanDto loanDto) {
        Loan loan = findById(id);

        Loan loanUpdate = loanMapper.toEntity(loanDto);
        loanUpdate.setId(loan.getId());

        Loan updatedLoan = loanRepository.save(loanUpdate);
        return loanMapper.toDto(updatedLoan);
    }

    @Override
    public void delete(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan with id " + id + " not found"));
        loanRepository.delete(loan);
    }

    @Override
    public Page<LoanDto> findByUserId(Long userId, Pageable pageable) {
        Page<Loan> loans = loanRepository.findByUserId(userId, pageable);
        return loans.map(loanMapper::toDto);
    }
}
