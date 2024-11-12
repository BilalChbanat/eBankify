package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.AccountDto;
import com.bank.ebankify.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "owner.id", source = "ownerId")
    Account toEntity(AccountDto accountDto);

    @Mapping(target = "ownerId", source = "owner.id")
    AccountDto toDto(Account account);
}
