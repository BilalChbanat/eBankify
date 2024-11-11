package com.bank.ebankify.mapper;


import com.bank.ebankify.dto.UserDto;
import com.bank.ebankify.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);

    void updateFromDto(UserDto userDto, @MappingTarget User user);


}