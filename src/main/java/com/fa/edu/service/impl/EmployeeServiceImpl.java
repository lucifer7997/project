package com.fa.edu.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.edu.dto.EmployeeDto;
import com.fa.edu.entities.Emplooyee;
import com.fa.edu.mapper.EmployeeMapper;
import com.fa.edu.repository.EmployeeRepository;
import com.fa.edu.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeDto> getAll() {
		List<Emplooyee> employees = employeeRepository.findByActive(true);
		return employeeMapper.toDtosList(employees);
	}

	@Override
	public EmployeeDto createObj(EmployeeDto obj) {
		Emplooyee employee = employeeMapper.toEntity(obj);
		employee.setCreateDate(LocalDate.now());
		Optional<Emplooyee> findById = employeeRepository.findById(employee.getId());
		if (findById.isEmpty()) {
			return employeeMapper.toDto(employeeRepository.save(employee));
		}
		return null;
	}

	@Override
	public EmployeeDto updateObj(EmployeeDto obj) {
		obj.setUpdateDate(LocalDate.now());

		return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(obj)));
	}

	@Override
	public EmployeeDto getById(String key) {
		// TODO Auto-generated method stub
		return employeeMapper.toDto(employeeRepository.getById(key));
	}

	@Override
	public boolean deleteById(String key) {
		try {
			employeeRepository.deleteById(key);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
