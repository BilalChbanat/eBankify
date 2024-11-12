package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
