package com.bank.ebankify.services;

import com.bank.ebankify.mapper.UserMapper;
import com.bank.ebankify.model.User;
import com.bank.ebankify.repository.UserRepository;
import com.bank.ebankify.service.implementation.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class); // Mock the UserRepository
        userMapper = mock(UserMapper.class); // Mock the UserMapper
        userService = new UserServiceImpl(userRepository, userMapper); // Pass both mocks to the service
    }

    @Test
    void testFindUserById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUsername("John Doe");

        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setUsername("John Doe");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userMapper.toDto(user)).thenReturn(userDto);

        User foundUser = userService.findById(userId);

        assertNotNull(foundUser);
        assertEquals(userId, foundUser.getId());
        assertEquals("John Doe", foundUser.getUsername());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setUsername("Jane Doe");
        user.setPassword("securePassword123");

        UserDto userDto = new UserDto();
        userDto.setUsername("Jane Doe");
        userDto.setPassword("securePassword123");

        when(userMapper.toEntity(userDto)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toDto(user)).thenReturn(userDto);

        UserDto createdUser = userService.create(userDto);

        assertNotNull(createdUser);
        assertEquals("Jane Doe", createdUser.getUsername());
        assertEquals("securePassword123", createdUser.getPassword()); // Verify password
        verify(userRepository, times(1)).save(user); // Verify repository method was called
    }


    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(user);

        // Act
        userService.delete(userId);

        // Assert
        verify(userRepository, times(1)).delete(user);
    }
}
