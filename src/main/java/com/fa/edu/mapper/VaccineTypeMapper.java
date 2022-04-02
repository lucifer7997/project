package com.fa.edu.mapper;

import org.mapstruct.Mapper;

import com.fa.edu.dto.VaccineTypeDto;
import com.fa.edu.entities.VaccineType;

@Mapper(componentModel = "spring")
public interface VaccineTypeMapper extends EntityMapper<VaccineTypeDto, VaccineType> {

}
