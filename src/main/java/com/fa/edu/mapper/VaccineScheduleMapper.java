package com.fa.edu.mapper;

import org.mapstruct.Mapper;

import com.fa.edu.dto.VaccineScheduleDto;
import com.fa.edu.entities.VaccineSchedule;

@Mapper(componentModel = "spring")
public interface VaccineScheduleMapper extends EntityMapper<VaccineScheduleDto, VaccineSchedule> {

}
