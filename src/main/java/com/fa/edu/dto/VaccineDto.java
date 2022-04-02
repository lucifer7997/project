package com.fa.edu.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDto {

	@NotBlank
	private String vaccineId;

	@NotNull
	private Boolean status;

	@NotBlank
	private String vaccineName;

	@NotBlank
	private String type;

	private String usage;

	private String indication;

	private String contraindication;

	private int number;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

	private String origin;

}
