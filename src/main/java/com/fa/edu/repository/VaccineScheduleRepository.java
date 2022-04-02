package com.fa.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.edu.entities.VaccineSchedule;

@Repository
public interface VaccineScheduleRepository extends JpaRepository<VaccineSchedule, Integer> {

}
