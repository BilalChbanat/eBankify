package com.bank.ebankify.mapper;


import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    Account toEntity(AccountDto accountDto);

    @Mapping(target = "isActive", ignore = true)
    AccountDto toDto(Account account);

    @Mapping(target = "id", ignore = true)
    void updateFromDto(@MappingTarget AccountDto accountDto, Account account);
}
