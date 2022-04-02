package com.fa.edu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.edu.dto.VaccineDto;
import com.fa.edu.entities.Vaccine;
import com.fa.edu.mapper.VaccineMapper;
import com.fa.edu.repository.VaccineRepository;
import com.fa.edu.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	@Autowired
	private VaccineRepository vaccineRepository;

	@Autowired
	private VaccineMapper vaccineMapper;

	@Override
	public List<VaccineDto> getAll() {

		return vaccineMapper.toDtosList(vaccineRepository.findAll());
	}

	@Override
	public VaccineDto createObj(VaccineDto obj) {
		Vaccine vaccine = vaccineMapper.toEntity(obj);
		Optional<Vaccine> findById = vaccineRepository.findById(vaccine.getVaccineId());
		if (findById.isEmpty()) {

			return vaccineMapper.toDto(vaccineRepository.save(vaccine));
		}
		return null;
	}

	@Override
	public VaccineDto updateObj(VaccineDto obj) {
		Vaccine entity = vaccineMapper.toEntity(obj);
		return vaccineMapper.toDto(vaccineRepository.save(entity));
	}

	@Override
	public VaccineDto getById(String key) {
		// TODO Auto-generated method stub
		return vaccineMapper.toDto(vaccineRepository.getById(key));
	}

	@Override
	public boolean deleteById(String key) {
		// TODO Auto-generated method stub
		return false;
	}

}
