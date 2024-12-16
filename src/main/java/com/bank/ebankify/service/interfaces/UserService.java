package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.authDto.RegisterDto;
import com.bank.ebankify.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    RegisterDto create(RegisterDto userDto);
    Page<RegisterDto> findAll(Pageable pageable);
    User findById(Long id);
    RegisterDto update(Long id, RegisterDto userDto);
    void delete(Long id);
    Page<RegisterDto> findByRole(String role, Pageable pageable);
}
