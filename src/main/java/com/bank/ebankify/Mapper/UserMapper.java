package com.bank.ebankify.Mapper;


import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "isActive", ignore = true)
    UserDto toDto(User user);

}