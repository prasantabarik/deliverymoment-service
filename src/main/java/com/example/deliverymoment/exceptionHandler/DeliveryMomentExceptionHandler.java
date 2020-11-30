package com.example.deliverymoment.exceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@RestController
public class DeliveryMomentExceptionHandler extends ResponseEntityExceptionHandler {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(ConstraintViolationException e) {
		List<String> errorMessageList = new ArrayList<String>();
		LOGGER.info(" Inside the Exception Handler ");
		Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();
		for (ConstraintViolation<?> violation : violationSet) {
			LOGGER.info(" violation.getMessage() " + violation.getMessage());
			errorMessageList.add(violation.getMessage());
		}
		LOGGER.info(" errorMessageList " + errorMessageList);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageList);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error(" ServiceExceptionHandler:Exception {}",
				ex.getBindingResult().getFieldError().getDefaultMessage());

		List<String> errors = new ArrayList<String>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			errors.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}
