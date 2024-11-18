package com.bank.ebankify.controller;


import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.service.interfaces.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/save")
    public ResponseEntity<LoanDto> saveLoan(@RequestBody LoanDto loanDto) {
        LoanDto savedLoan = loanService.create(loanDto);
        return ResponseEntity.ok(savedLoan);
    }

    @GetMapping
    public ResponseEntity<Page<LoanDto>> getAllLoans(Pageable pageable) {
        Page<LoanDto> loans = loanService.findAll(pageable);
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable Long id, @RequestBody LoanDto loanDto) {
        LoanDto updatedLoan = loanService.update(id, loanDto);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
