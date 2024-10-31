package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.service.interfaces.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class AccountServiceImp implements AccountService {
    @Override
    public AccountDto create(AccountDto accountDto) {
        return null;
    }

    @Override
    public Page<AccountDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<AccountDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<AccountDto> findByUserId(Long userId, Pageable pageable) {
        return null;
    }
}
