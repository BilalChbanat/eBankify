package com.bank.ebankify.controller;

import com.bank.ebankify.dto.authDto.RegisterDto;
import com.bank.ebankify.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<RegisterDto> createUser(@RequestBody RegisterDto userDto) {
        RegisterDto createdUser = userService.create(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<Page<RegisterDto>> getAllUsers(Pageable pageable) {
        Page<RegisterDto> users = userService.findAll(pageable);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RegisterDto> updateUser(@PathVariable Long id, @RequestBody RegisterDto userDto) {
        RegisterDto updatedUser = userService.update(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
