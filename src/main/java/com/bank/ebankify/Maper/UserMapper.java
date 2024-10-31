package com.bank.ebankify.Maper;


import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;

import java.math.BigDecimal;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .age(user.getAge())
                .monthlyIncome(user.getMonthlyIncome())
                .creditScore(user.getCreditScore())
                .role(user.getRole())
                .build();
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setMonthlyIncome(userDto.getMonthlyIncome());
        user.setCreditScore(userDto.getCreditScore());
        user.setRole(userDto.getRole());
        return user;
    }
}