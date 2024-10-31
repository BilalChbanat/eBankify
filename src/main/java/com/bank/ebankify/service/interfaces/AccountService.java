package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {
    AccountDto create(AccountDto accountDto);
    Page<AccountDto> findAll(Pageable pageable);
    Optional<AccountDto> findById(Long id);
    AccountDto update(Long id, AccountDto accountDto);
    void delete(Long id);
    Page<AccountDto> findByUserId(Long userId, Pageable pageable);
}
