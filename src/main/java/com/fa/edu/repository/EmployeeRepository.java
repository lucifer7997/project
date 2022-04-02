package com.fa.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.edu.entities.Emplooyee;

@Repository
public interface EmployeeRepository extends JpaRepository<Emplooyee, String> {
	List<Emplooyee> findByActive(Boolean active);
}
