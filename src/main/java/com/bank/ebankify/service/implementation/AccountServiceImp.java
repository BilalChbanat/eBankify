package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.mapper.AccountMapper;
import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.User;
import com.bank.ebankify.repository.AccountRepository;
import com.bank.ebankify.repository.UserRepository;
import com.bank.ebankify.service.interfaces.AccountService;
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
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        if (accountDto.getOwnerId() != null) {
            User owner = userRepository.findById(accountDto.getOwnerId())
                    .orElseThrow(() -> new RuntimeException("Owner not found"));
            account.setOwner(owner);
        }
        account = accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    @Override
    public Page<AccountDto> findAll(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return accounts.map(accountMapper::toDto);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        Account account = findById(id);

        Account accountUpdate = accountMapper.toEntity(accountDto);
        accountUpdate.setId(account.getId());

        Account updatedAccount = accountRepository.save(accountUpdate);
        return accountMapper.toDto(updatedAccount);
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
