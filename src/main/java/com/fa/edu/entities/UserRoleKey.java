package com.fa.edu.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class UserRoleKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne	
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	private AppUser appUser;
	
	@ManyToOne	
	@JoinColumn(name = "role_id" , referencedColumnName = "id")
	private AppRole appRole;
}

