package com.bank.ebankify.service.implementation;

import com.bank.ebankify.Mapper.UserMapper;
import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import com.bank.ebankify.repository.UserRepository;
import com.bank.ebankify.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
        return userDto;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toDto);
    }

    @Override
    public User findById(Long id) {
        return null;
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
