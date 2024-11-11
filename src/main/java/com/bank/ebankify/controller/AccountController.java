package com.bank.ebankify.controller;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.service.interfaces.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.create(accountDto);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping
    public ResponseEntity<Page<AccountDto>> getAllAccounts(Pageable pageable) {
        Page<AccountDto> accounts = accountService.findAll(pageable);
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto) {
        AccountDto updatedAccount = accountService.update(id, accountDto);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
