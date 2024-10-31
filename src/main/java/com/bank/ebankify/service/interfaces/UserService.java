package com.bank.ebankify.service.interfaces;

import com.bank.ebankify.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserService {
    UserDto create(UserDto userDto);
    Page<UserDto> findAll(Pageable pageable);
    Optional<UserDto> findById(Long id);
    UserDto update(Long id, UserDto userDto);
    void delete(Long id);
    Page<UserDto> findByRole(String role, Pageable pageable);
}
