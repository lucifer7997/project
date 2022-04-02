package com.fa.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VaccineType", schema = "dbo")
public class VaccineType {
	@Id
	@Column
	private String code;

	@NotBlank
	@Column(columnDefinition = "NVARCHAR(50)")
	private String vaccineTypeName;

	@Column(columnDefinition = "NVARCHAR(200)")
	private String description;

	@NotBlank
	@Column
	private String status;
}
