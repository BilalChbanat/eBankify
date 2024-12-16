package com.bank.ebankify.repository;

import com.bank.ebankify.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByRole(String role, Pageable pageable);
    Optional<User> findByEmail(String email);

}
