package com.bank.ebankify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private String accountNumber;
    private Double balance;
    private Long ownerId;
    private boolean isActive;

    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerId=" + ownerId +
                ", isActive=" + isActive +
                '}';
    }
}
