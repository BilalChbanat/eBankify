package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.mapper.AccountMapper;
import com.bank.ebankify.model.Account;
import com.bank.ebankify.repository.AccountRepository;
import com.bank.ebankify.service.interfaces.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        accountRepository.save(accountMapper.toEntity(accountDto));
        return accountDto;
    }

    @Override
    public Page<AccountDto> findAll(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return accounts.map(accountMapper::toDto);
    }

    @Override
    public Optional<AccountDto> findById(Long id) {
        return accountRepository.findById(id).map(accountMapper::toDto);
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accountMapper.updateFromDto(accountDto, account);
        accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account with id " + id + " not found"));
        accountRepository.delete(account);
    }

    @Override
    public Page<AccountDto> findByUserId(Long userId, Pageable pageable) {
        Page<Account> accounts = accountRepository.findByOwner_Id(userId, pageable);
        return accounts.map(accountMapper::toDto);
    }

    @Override
    public Page<AccountDto> findIsActive(boolean isActive, Pageable pageable) {
        Page<Account> accounts = accountRepository.findByActive(isActive, pageable);
        return accounts.map(accountMapper::toDto);
    }
}
