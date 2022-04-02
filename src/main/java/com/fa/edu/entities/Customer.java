package com.fa.edu.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column
	private String card;

	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String fullName;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfBirth;

	@Column
	@NotBlank
	private String gender;

	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String address;

	@Column(columnDefinition = "NVARCHAR(10)")
	@NotBlank
	private String userName;

	@Column
	@NotNull
	private String password;

	@Column
	@NotNull
	private String confirmPassword;

	@Column
	@Email
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String phone;
}
