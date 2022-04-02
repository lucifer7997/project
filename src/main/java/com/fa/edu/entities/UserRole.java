package com.fa.edu.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_role" , schema = "dbo")
public class UserRole {

	@EmbeddedId
	private UserRoleKey key; 
}


