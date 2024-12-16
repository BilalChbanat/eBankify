package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.authDto.RegisterDto;
import com.bank.ebankify.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RegisterDto userDto);
    RegisterDto toDto(User user);
}
