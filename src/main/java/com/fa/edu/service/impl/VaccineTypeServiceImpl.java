package com.fa.edu.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.edu.dto.VaccineTypeDto;
import com.fa.edu.entities.VaccineType;
import com.fa.edu.mapper.VaccineTypeMapper;
import com.fa.edu.repository.VaccineTypeRepository;
import com.fa.edu.service.VaccineTypeService;

@Service
public class VaccineTypeServiceImpl implements VaccineTypeService {
	@Autowired
	private VaccineTypeRepository vaccineTypeRepository;

	@Autowired
	private VaccineTypeMapper vaccineTypeMapper;

	@Override
	public List<VaccineTypeDto> getAll() {
		List<VaccineType> vaccines = vaccineTypeRepository.findAll();
		return vaccineTypeMapper.toDtosList(vaccines);
	}

	@Override
	public VaccineTypeDto createObj(VaccineTypeDto obj) {
		VaccineType vaccineType = vaccineTypeMapper.toEntity(obj);
		Optional<VaccineType> findById = vaccineTypeRepository.findById(vaccineType.getCode());
		if (findById.isEmpty()) {
			return vaccineTypeMapper.toDto(vaccineTypeRepository.save(vaccineType));
		} else
			return null;
	}

	@Override
	public VaccineTypeDto updateObj(VaccineTypeDto obj) {
		return vaccineTypeMapper.toDto(vaccineTypeRepository.save(vaccineTypeMapper.toEntity(obj)));
	}

	@Override
	public VaccineTypeDto getById(String key) {
		return vaccineTypeMapper.toDto(vaccineTypeRepository.getById(key));
	}

	@Override
	public boolean deleteById(String key) {
		try {
			vaccineTypeRepository.deleteById(key);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

}
