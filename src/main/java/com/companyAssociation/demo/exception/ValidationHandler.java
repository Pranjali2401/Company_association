package com.companyAssociation.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();

			errors.put(fieldName, message);

		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}
//	java.lang.NumberFormatException:

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex, WebRequest reques) {

		return new ResponseEntity<>("NumberFormatException : 000", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorModel handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest reques) {
		return new ErrorModel("ConstraintViolationException : 000", ex);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
			Exception exception) {

		Map<String, Object> body = new HashMap<>();
		body.put("TimeStemp", LocalDateTime.now());
		body.put("Message", "Duplicate Manager Name please change the name");

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException ex, WebRequest reques) {

		Map<String, Object> body = new HashMap<>();
		body.put("TimeStemp", LocalDateTime.now());
		body.put("Message", ex.getMessage());

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

	}

}
