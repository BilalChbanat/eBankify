package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import com.bank.ebankify.enums.RoleEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
    void updateFromDto(UserDto userDto, @MappingTarget User user);
}