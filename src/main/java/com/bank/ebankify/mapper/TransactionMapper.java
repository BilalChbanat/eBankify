package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.TransactionDto;
import com.bank.ebankify.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface TransactionMapper {

    @Mapping(source = "accountFromId", target = "accountFrom.id")
    @Mapping(source = "accountToId", target = "accountTo.id")
    Transaction toEntity(TransactionDto transactionDto);

    @Mapping(source = "accountFrom.id", target = "accountFromId")
    @Mapping(source = "accountTo.id", target = "accountToId")
    TransactionDto toDto(Transaction transaction);
}
