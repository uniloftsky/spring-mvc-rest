package com.uniloftsky.springframework.springmvcrest.api.v1.mapper;

import com.uniloftsky.springframework.model.CustomerDTO;
import com.uniloftsky.springframework.springmvcrest.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDTO);

}
