package com.fa.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "app_user" , schema = "dbo")
public class AppUser {
	
	@Id
	@Column
	private Long id;
	
	@Column(name = "username" , unique = true, nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "enable")
	private boolean enable;

}
