package com.fa.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineTypeDto {
	private String code;
	private String vaccineTypeName;
	private String status;
	private String description;
}
