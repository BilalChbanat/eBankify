package com.bank.ebankify.dto;

import com.bank.ebankify.enums.TransactionStatusEnum;
import com.bank.ebankify.enums.TransactionTypeEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {

    private Long id;
    private TransactionTypeEnum type;
    private Double amount;
    private LocalDate date;
    private Long accountFromId;
    private Long accountToId;
    private Double fee;
    private TransactionStatusEnum status;

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", accountFromId=" + accountFromId +
                ", accountToId=" + accountToId +
                ", fee=" + fee +
                ", status=" + status +
                '}';
    }
}
