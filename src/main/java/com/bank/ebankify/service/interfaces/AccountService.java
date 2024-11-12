package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    AccountDto create(AccountDto accountDto);
    Page<AccountDto> findAll(Pageable pageable);
    Account findById(Long id);
    AccountDto update(Long id, AccountDto accountDto);
    void delete(Long id);
    Page<AccountDto> findByUserId(Long userId, Pageable pageable);

    Page<AccountDto> findIsActive(boolean isActive, Pageable pageable);
}
