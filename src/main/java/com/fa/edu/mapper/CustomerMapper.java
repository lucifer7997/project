package com.fa.edu.mapper;

import org.mapstruct.Mapper;

import com.fa.edu.dto.CustomerDto;
import com.fa.edu.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDto, Customer> {

}
