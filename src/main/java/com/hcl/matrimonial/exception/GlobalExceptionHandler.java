package com.hcl.matrimonial.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { List<String> details = new
	 * ArrayList<>(); for(ObjectError error : ex.getBindingResult().getAllErrors())
	 * { details.add(error.getDefaultMessage()); } ResponseData error = new
	 * ResponseData("Validation Failed", status, details); return new
	 * ResponseEntity<>(error, HttpStatus.BAD_REQUEST); }
	 * 
	 * @ExceptionHandler(ResourceNotFoundException.class) public final
	 * ResponseEntity<Object> handleAllExceptions(ResourceNotFoundException ex,
	 * WebRequest request) { List<String> details = new ArrayList<>();
	 * details.add(ex.getMessage()); ResponseData error = new
	 * ResponseData(ex.getMessage(), HttpStatus.BAD_REQUEST, null); return new
	 * ResponseEntity<>(error, error.getHttpStatus()); }
	 * 
	 * @ExceptionHandler(BookMyFlightException.class) public final
	 * ResponseEntity<Object> handleAllExceptions(BookMyFlightException ex,
	 * WebRequest request) { List<String> details = new ArrayList<>();
	 * details.add(ex.getMessage()); ResponseData error = new
	 * ResponseData(ex.getMessage(), HttpStatus.BAD_REQUEST, null); return new
	 * ResponseEntity<>(error, error.getHttpStatus()); }
	 */}
