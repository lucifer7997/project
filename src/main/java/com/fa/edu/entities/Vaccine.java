package com.fa.edu.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "Vaccine", schema = "dbo")
public class Vaccine {
	@NotBlank
	@Id
	@Column
	private String vaccineId;
	
	@NotNull
	@Column
	private Boolean status;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String vaccineName;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String type;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	private String usage;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	private String indication;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	private String contraindication;
	
	@Column
	private int number;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@Column(columnDefinition = "NVARCHAR(100)")
	private String origin;
	
}
