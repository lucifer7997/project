package com.fa.edu.mapper;


import org.mapstruct.Mapper;

import com.fa.edu.dto.EmployeeDto;
import com.fa.edu.entities.Emplooyee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Emplooyee> {

}
