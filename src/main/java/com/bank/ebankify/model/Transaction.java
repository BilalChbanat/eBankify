package com.bank.ebankify.model;

import com.bank.ebankify.enums.TransactionStatusEnum;
import com.bank.ebankify.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionTypeEnum type;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "account_from_id", nullable = false)
    private Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to_id", nullable = false)
    private Account accountTo;

    @Column(name = "fee", nullable = false)
    private Double fee = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatusEnum status;
}
