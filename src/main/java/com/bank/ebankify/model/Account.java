package com.bank.ebankify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "owner_id")
    private Long owner_id ;

    @Column(name = "is_active")
    private boolean is_active;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_number='" + account_number + '\'' +
                ", balance=" + balance +
                ", owner_id=" + owner_id +
                '}';
    }
}
