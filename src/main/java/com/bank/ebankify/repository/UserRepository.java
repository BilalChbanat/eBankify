package com.bank.ebankify.repository;

import com.bank.ebankify.dto.UserDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserDto, Long> {

    Page<UserDto> findByRole(String role, Pageable pageable);
    UserDto findByEmail(String email);
}
