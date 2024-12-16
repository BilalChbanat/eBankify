package com.bank.ebankify.dto.authDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RegisterDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private int age;
    private BigDecimal monthlyIncome;
    private BigDecimal creditScore;
    private String role;
}