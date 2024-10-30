package com.bank.ebankify.dto;

import com.bank.ebankify.ENUM.loan_status_enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {

    private Long id;
    private double amount;
    private double interestRate;
    private int duration;
    private String eligibilityCriteria;
    private loan_status_enum status;
    private Long userId;

    @Override
    public String toString() {
        return "LoanDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", duration=" + duration +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
