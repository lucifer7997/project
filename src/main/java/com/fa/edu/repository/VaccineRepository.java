package com.fa.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.edu.entities.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, String> {

}
