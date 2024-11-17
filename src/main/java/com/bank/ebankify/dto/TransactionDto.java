package com.bank.ebankify.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
    private Long id;
    private String type;
    private Double amount;
    private LocalDate date;
    private Long accountFromId;
    private Long accountToId;
    private Double fee;
    private String status;
}

