package com.bank.ebankify.repository;

import com.bank.ebankify.dto.UserDto;

import com.bank.ebankify.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByRole(String role, Pageable pageable);
    User findByEmail(String email);
}
