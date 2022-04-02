package com.fa.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.edu.entities.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

}
