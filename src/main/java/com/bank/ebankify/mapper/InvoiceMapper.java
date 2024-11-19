package com.bank.ebankify.mapper;

import com.bank.ebankify.dto.InvoiceDto;
import com.bank.ebankify.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(source = "user.id", target = "userId")
    InvoiceDto toDto(Invoice invoice);

    @Mapping(source = "userId", target = "user.id")
    Invoice toEntity(InvoiceDto invoiceDto);
}
