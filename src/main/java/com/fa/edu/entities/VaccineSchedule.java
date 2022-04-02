package com.fa.edu.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VaccineSchedule", schema = "dbo")
public class VaccineSchedule {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;

	@Column(columnDefinition = "NVARCHAR(100)")
	@NotNull
	private String vaccine;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate fromDate;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate toDate;

	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String place;

	@Column(columnDefinition = "NVARCHAR(100)")
	private String note;

	public VaccineSchedule(LocalDate from, LocalDate to, String place, String note) {
		super();
		this.fromDate = from;
		this.toDate = to;
		this.place = place;
		this.note = note;
	}

}
