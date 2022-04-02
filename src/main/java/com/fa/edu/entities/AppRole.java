package com.fa.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "app_role" , schema = "dbo")
public class AppRole {

	@Id
	@Column
	private long id;
	
	@Column(name = "Role_Name" , nullable = false)
	private String name;
}
