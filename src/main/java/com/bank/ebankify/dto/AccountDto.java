package com.bank.ebankify.dto;

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

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerId=" + (ownerId != null ? ownerId : "null") +
                ", isActive=" + isActive +
                '}';
    }
}
