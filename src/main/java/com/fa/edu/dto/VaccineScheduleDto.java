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
public class VaccineScheduleDto {
	private int scheduleId;
	@NotNull
	private String vaccine;

	@NotBlank
	private String place;
	private String note;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate fromDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate toDate;

	public String getStatus() {
		if (fromDate.compareTo(LocalDate.now()) > 0) {
			return "Not yet";
		}
		if (toDate.compareTo(LocalDate.now()) < 0) {
			return "Over";
		}
		return "Open";
	}
}
