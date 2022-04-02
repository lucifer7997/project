package com.fa.edu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.edu.dto.CustomerDto;
import com.fa.edu.entities.Customer;
import com.fa.edu.mapper.CustomerMapper;
import com.fa.edu.repository.CustomerRepository;
import com.fa.edu.service.CustomerSevice;

@Service
public class CustomerSeviceImpl implements CustomerSevice {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<CustomerDto> getAll() {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.toDtosList(customers);
	}

	@Override
	public CustomerDto createObj(CustomerDto obj) {
		Customer customer = customerMapper.toEntity(obj);
		Optional<Customer> findById = customerRepository.findById(customer.getCard());
		if (findById.isEmpty()) {
			return customerMapper.toDto(customerRepository.save(customer));
		}
		return null;
	}

	@Override
	public CustomerDto updateObj(CustomerDto obj) {
		return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(obj)));
	}

	@Override
	public CustomerDto getById(String key) {
		return customerMapper.toDto(customerRepository.getById(key));
	}

	@Override
	public boolean deleteById(String key) {
		try {
			customerRepository.deleteById(key);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
