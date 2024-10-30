package com.bank.ebankify.dto;

import com.bank.ebankify.ENUM.role_enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private int age;
    private Double monthlyIncome;
    private Double creditScore;
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
