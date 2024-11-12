package com.bank.ebankify.dto;


import com.bank.ebankify.enums.RoleEnum;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private int age;
    private BigDecimal monthlyIncome;
    private BigDecimal creditScore;
    private String password;
    private String role;
}