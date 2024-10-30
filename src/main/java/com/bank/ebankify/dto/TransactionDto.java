package com.bank.ebankify.dto;

import com.bank.ebankify.ENUM.transaction_status_enum;
import com.bank.ebankify.ENUM.transaction_type_enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Long id;
    private transaction_type_enum type;
    private Double amount;
    private LocalDate date;
    private Long accountFromId;
    private Long accountToId;
    private Double fee;
    private transaction_status_enum status;

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
