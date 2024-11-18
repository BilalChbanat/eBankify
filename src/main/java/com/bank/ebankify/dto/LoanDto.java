package com.bank.ebankify.dto;

import com.bank.ebankify.enums.LoanStatusEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDto {

    private Long id;
    private double amount;
    private double interestRate;
    private int duration;
    private String eligibilityCriteria;
    private LoanStatusEnum status;
    private Long userId;


}
