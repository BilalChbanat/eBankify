package com.bank.ebankify.model;

import com.bank.ebankify.enums.LoanStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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

    @Positive
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Positive
    @Column(name = "interest_rate", nullable = false)
    private BigDecimal interestRate;

    @Positive
    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "eligibility_criteria")
    private String eligibilityCriteria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LoanStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
