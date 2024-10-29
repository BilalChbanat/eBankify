package com.bank.ebankify.model;


import com.bank.ebankify.ENUM.transaction_status_enum;
import com.bank.ebankify.ENUM.transaction_type_enum;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private transaction_type_enum type ;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "account_from_id")
    private Long account_from_id;

    @Column(name = "account_to_id")
    private Long account_to_id;

    @Column(name = "fee")
    private Double fee ;

    @Column(name = "status")
    private transaction_status_enum status ;
}
