package com.bank.ebankify.repository;

import com.bank.ebankify.model.Account;
import com.bank.ebankify.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Page<Account> findByActive(boolean isActive, Pageable pageable);
    Page<Account> findByOwner_Id(Long owner, Pageable pageable);
}
