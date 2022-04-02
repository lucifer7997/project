package com.fa.edu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.edu.dto.VaccineScheduleDto;
import com.fa.edu.entities.VaccineSchedule;
import com.fa.edu.mapper.VaccineScheduleMapper;
import com.fa.edu.repository.VaccineScheduleRepository;
import com.fa.edu.service.VaccineScheduleService;

@Service
public class VaccineScheduleServiceImpl implements VaccineScheduleService {
	@Autowired
	private VaccineScheduleRepository vaccineScheduleRepository;

	@Autowired
	private VaccineScheduleMapper vaccineScheduleMapper;

	@Override
	public List<VaccineScheduleDto> getAll() {
		List<VaccineSchedule> vaccineSchedules = vaccineScheduleRepository.findAll();
		return vaccineScheduleMapper.toDtosList(vaccineSchedules);
	}

	@Override
	public VaccineScheduleDto createObj(VaccineScheduleDto obj) {
		VaccineSchedule vaccineSchedule = vaccineScheduleMapper.toEntity(obj);
		Optional<VaccineSchedule> findById = vaccineScheduleRepository.findById(vaccineSchedule.getScheduleId());
		if (findById.isEmpty()) {
			return vaccineScheduleMapper.toDto(vaccineScheduleRepository.save(vaccineSchedule));
		}
		return null;
	}

	@Override
	public VaccineScheduleDto updateObj(VaccineScheduleDto obj) {
		return vaccineScheduleMapper.toDto(vaccineScheduleRepository.save(vaccineScheduleMapper.toEntity(obj)));
	}

	@Override
	public VaccineScheduleDto getById(Integer key) {
		return vaccineScheduleMapper.toDto(vaccineScheduleRepository.getById(key));
	}


	@Override
	public boolean deleteById(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}
}
