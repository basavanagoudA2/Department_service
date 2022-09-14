package com.bm.world.dep.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {
	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<Object> depertmentNotFoundExcption(EntityNotFoundException exception) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(exception.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(value = DepartmentsNotFoundException.class)
	public ResponseEntity<Object> handle(DepartmentsNotFoundException exception) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(exception.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
