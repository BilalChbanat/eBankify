package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.TransactionDto;
import com.bank.ebankify.mapper.TransactionMapper;
import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.Transaction;
import com.bank.ebankify.repository.AccountRepository;
import com.bank.ebankify.repository.TransactionRepository;
import com.bank.ebankify.service.interfaces.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        Transaction transaction = transactionMapper.toEntity(transactionDto);

        Account accountFrom = accountRepository.findById(transactionDto.getAccountFromId())
                .orElseThrow(() -> new RuntimeException("Account From not found"));
        Account accountTo = accountRepository.findById(transactionDto.getAccountToId())
                .orElseThrow(() -> new RuntimeException("Account To not found"));

        BigDecimal amount = BigDecimal.valueOf(transactionDto.getAmount());
        if (accountFrom.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance in accountFrom");
        }

        accountFrom.setBalance(accountFrom.getBalance().subtract(amount));
        accountTo.setBalance(accountTo.getBalance().add(amount));

        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);

        transaction.setAccountFrom(accountFrom);
        transaction.setAccountTo(accountTo);

        transaction = transactionRepository.save(transaction);
        return transactionMapper.toDto(transaction);
    }

    @Override
    public Page<TransactionDto> findAll(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return transactions.map(transactionMapper::toDto);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public TransactionDto update(Long id, TransactionDto transactionDto) {
        Transaction existingTransaction = findById(id);

        Account accountFrom = accountRepository.findById(transactionDto.getAccountFromId())
                .orElseThrow(() -> new RuntimeException("Account from not found"));
        Account accountTo = accountRepository.findById(transactionDto.getAccountToId())
                .orElseThrow(() -> new RuntimeException("Account to not found"));

        Transaction transactionToUpdate = transactionMapper.toEntity(transactionDto);
        transactionToUpdate.setId(existingTransaction.getId());
        transactionToUpdate.setAccountFrom(accountFrom);
        transactionToUpdate.setAccountTo(accountTo);

        Transaction updatedTransaction = transactionRepository.save(transactionToUpdate);
        return transactionMapper.toDto(updatedTransaction);
    }



    @Override
    public void delete(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transactionRepository.delete(transaction);
    }

}
