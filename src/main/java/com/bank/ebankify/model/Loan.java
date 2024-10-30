package com.bank.ebankify.model;

import com.bank.ebankify.ENUM.loan_status_enum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "interest_rate", nullable = false)
    private double interestRate;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "eligibility_criteria")
    private String eligibilityCriteria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private loan_status_enum status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", duration=" + duration +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                ", status=" + status +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}
