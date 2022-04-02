package com.fa.edu.dto;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class EmployeeDto {
	
	@NotBlank
	private String id;
	
	@NotBlank
	private String name;
	
	private String position;
	
	@NotBlank
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfBirth;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String address;
	
	@NotBlank
	@Email
	private String email;
	
	private String workingPlace;
	
	private LocalDate createDate;
	
	private LocalDate updateDate;

	@Column(nullable = true, length = 64)
	private String photos;

	public String getPhotosImagePath() {
		if (photos == null || id == null)
			return null;

		return "user-photos/" + id + "/" + photos;
	}
	
	private Boolean active = true;
}
