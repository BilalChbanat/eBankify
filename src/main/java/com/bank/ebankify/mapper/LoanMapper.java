package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.LoanDto;
import com.bank.ebankify.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(source = "user.id", target = "userId") // Map User's ID to userId in DTO
    LoanDto toDto(Loan loan);

    @Mapping(source = "userId", target = "user.id") // Map userId in DTO to User's ID in entity
    Loan toEntity(LoanDto loanDto);
}
