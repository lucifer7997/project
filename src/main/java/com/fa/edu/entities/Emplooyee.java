package com.fa.edu.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Emplpyee", schema = "dbo")
@Entity
public class Emplooyee {

	@Id
	@Column
	private String id;

	@Column(columnDefinition = "NVARCHAR(100)")
	@NotBlank
	private String name;

	@Column
	private String image;

	@Column
	@Size(max = 100)
	private String position;

	@Column
	@NotBlank
	private String gender;

	@Column
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@Column
	@NotBlank
	private String phone;

	@Column(columnDefinition = "NVARCHAR(200)")
	@NotBlank
	private String address;

	@Column
	@NotBlank
	@Email
	private String email;

	@Column
	private String workingPlace;

	@Column
	private LocalDate createDate;

	@Column
	private LocalDate updateDate;
	
	@Column(nullable = true, length = 64)
	private String photos;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || id == null) return null;
         
        return "user-photos/" + id + "/" + photos;
    }
    
    @Column
	private Boolean active = true;
}
