package com.bank.ebankify.model;

import com.bank.ebankify.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "monthly_income", nullable = false)
    private BigDecimal monthlyIncome;

    @Column(name = "credit_score", nullable = false)
    private BigDecimal creditScore;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToOne(mappedBy = "owner", fetch = FetchType.LAZY)
    private Account account;

    public Account getAccount() {
        return account;
    }
}
