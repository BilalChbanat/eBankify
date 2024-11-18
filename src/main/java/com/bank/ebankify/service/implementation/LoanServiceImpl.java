package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.mapper.LoanMapper;
import com.bank.ebankify.model.Account;
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

import java.math.BigDecimal;

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
        // Fetch user
        User user = userRepository.findById(loanDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if user balance meets eligibility
        double loanAmount = loanDto.getAmount();
        double userBalance = user.getAccount().getBalance().doubleValue();
        double requiredBalance = loanAmount * 0.10; // Example: require 10% of loan amount as minimum balance

        if (userBalance < requiredBalance) {
            throw new RuntimeException("User does not meet the balance requirement for loan eligibility");
        }

        // Calculate monthly repayment amount
        double interestRate = loanDto.getInterestRate() / 100;
        int duration = loanDto.getDuration(); // Duration in months
        double monthlyRepayment = (loanAmount + (loanAmount * interestRate)) / duration;

        // Convert DTO to entity and set the user
        Loan loan = loanMapper.toEntity(loanDto);
        loan.setUser(user);

        // Save the loan
        Loan savedLoan = loanRepository.save(loan);

        // Schedule monthly repayment deductions
        scheduleMonthlyRepayment(user, monthlyRepayment, duration);

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

    private void scheduleMonthlyRepayment(User user, double monthlyRepayment, int duration) {
        Runnable task = () -> {
            for (int i = 0; i < duration; i++) {
                try {
                    // Simulate monthly deduction
                    Thread.sleep(30 * 24 * 60 * 60 * 1000L); // Approx 30 days in milliseconds

                    double currentBalance = user.getAccount().getBalance().doubleValue();

                    if (currentBalance < monthlyRepayment) {
                        throw new RuntimeException("Insufficient balance for monthly repayment");
                    }

                    // Deduct the repayment amount
                    user.getAccount().setBalance(BigDecimal.valueOf(currentBalance - monthlyRepayment));

                    // Save the updated user balance
                    userRepository.save(user);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Repayment task interrupted", e);
                }
            }
        };

        // Start the repayment task in a new thread
        new Thread(task).start();
    }



}
