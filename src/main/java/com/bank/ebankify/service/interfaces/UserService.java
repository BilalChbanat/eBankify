package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto create(UserDto userDto);
    Page<UserDto> findAll(Pageable pageable);
    User findById(Long id);
    UserDto update(Long id, UserDto userDto);
    void delete(Long id);
    Page<UserDto> findByRole(String role, Pageable pageable);
}
