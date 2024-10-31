package com.bank.ebankify.service.implementation;

import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.service.interfaces.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<UserDto> findByRole(String role, Pageable pageable) {
        return null;
    }
}
