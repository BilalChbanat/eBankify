package com.bank.ebankify.Maper;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.User;
import com.bank.ebankify.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final UserService userService;

    @Autowired
    public AccountMapper(UserService userService) {
        this.userService = userService;
    }

    public AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }

        return AccountDto.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .ownerId(account.getOwner() != null ? account.getOwner().getId() : null)
                .isActive(account.isActive())
                .build();
    }

    public Account toEntity(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        account.setActive(accountDto.isActive());

        if (accountDto.getOwnerId() != null) {
            User owner = userService.findById(accountDto.getOwnerId());
            account.setOwner(owner);
        }

        return account;
    }
}
