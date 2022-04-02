package com.fa.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fa.edu.entities.UserRole;
import com.fa.edu.entities.UserRoleKey;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,UserRoleKey> {

}
