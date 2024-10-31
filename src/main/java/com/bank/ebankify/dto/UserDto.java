package com.bank.ebankify.dto;

import com.bank.ebankify.ENUM.role_enum;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private int age;
    private BigDecimal monthlyIncome;
    private BigDecimal creditScore;
    private role_enum role;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", monthlyIncome=" + monthlyIncome +
                ", creditScore=" + creditScore +
                ", role=" + role +
                '}';
    }
}
