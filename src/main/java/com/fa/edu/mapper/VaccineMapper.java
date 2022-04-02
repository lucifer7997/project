package com.fa.edu.mapper;

import org.mapstruct.Mapper;

import com.fa.edu.dto.VaccineDto;
import com.fa.edu.entities.Vaccine;

@Mapper(componentModel = "spring")
public interface VaccineMapper extends EntityMapper<VaccineDto, Vaccine> {

}
