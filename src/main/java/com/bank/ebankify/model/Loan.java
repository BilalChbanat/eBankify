package com.bank.ebankify.model;

import com.bank.ebankify.ENUM.loan_status_enum;
import jakarta.persistence.*;


@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "interest_rate")
    private double interest_rate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "eligibility_criteria")
    private String eligibility_criteria;

    @Column(name = "status")
    private loan_status_enum status ;

    @Column(name = "user_id")
    private Long user_id;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", interest_rate=" + interest_rate +
                ", duration=" + duration +
                ", eligibility_criteria='" + eligibility_criteria + '\'' +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
