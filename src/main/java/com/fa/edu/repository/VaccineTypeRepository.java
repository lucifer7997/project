package com.fa.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fa.edu.entities.VaccineType;

public interface VaccineTypeRepository extends JpaRepository<VaccineType, String> {

}
