package com.bank.ebankify.dto;

import com.bank.ebankify.ENUM.invoice_status_enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;
    private Double amountDue;
    private LocalDate dueDate;
    private invoice_status_enum status;
    private Long userId;

    @Override
    public String toString() {
        return "InvoiceDto{" +
                "id=" + id +
                ", amountDue=" + amountDue +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
