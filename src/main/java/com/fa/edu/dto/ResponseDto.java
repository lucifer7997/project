package com.fa.edu.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDto<T> {

	private String message;
	private HttpStatus code;
	private T data;
}
