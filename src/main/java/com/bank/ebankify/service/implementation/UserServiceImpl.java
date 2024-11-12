package com.bank.ebankify.service.implementation;

import com.bank.ebankify.enums.RoleEnum;
import com.bank.ebankify.mapper.UserMapper;
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

import java.util.Arrays;

@Transactional
@RequiredArgsConstructor
@Service
@Setter
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        String roleStr = userDto.getRole();
        if (roleStr != null) {
            try {
                RoleEnum role = RoleEnum.valueOf(roleStr.toUpperCase());
                User user = userMapper.toEntity(userDto);
                user.setRole(role);
                user = userRepository.save(user);
                return userMapper.toDto(user);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid role. Must be one of: " +
                        Arrays.toString(RoleEnum.values()));
            }
        } else {
            User user = userMapper.toEntity(userDto);
            user.setRole(RoleEnum.USER);
            user = userRepository.save(user);
            return userMapper.toDto(user);
        }
    }


    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toDto);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = findById(id);

        User usertoUpdate = userMapper.toEntity(userDto);
        usertoUpdate.setId(id);

        User updatedUser = userRepository.save(usertoUpdate);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userRepository.delete(user);
    }


    @Override
    public Page<UserDto> findByRole(String role, Pageable pageable) {
        Page<User> users = userRepository.findByRole(role, pageable);
        return users.map(userMapper::toDto);
    }

}
