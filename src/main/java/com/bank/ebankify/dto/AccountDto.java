package com.bank.ebankify.dto;

import com.bank.ebankify.model.User;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long ownerId;
    private boolean isActive;

}
