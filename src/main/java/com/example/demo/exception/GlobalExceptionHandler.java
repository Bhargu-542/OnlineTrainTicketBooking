package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler( NotBookedException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(NotBookedException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatuscode(401);
        errorResponse.setDateTime(LocalDateTime.now());

 

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exceptionHandling(MethodArgumentNotValidException exception){
		ErrorResponse errorDetails = new ErrorResponse();
		List<FieldError> list = exception.getBindingResult().getFieldErrors();
		for(FieldError errorDetail:list) {
			errorDetails.getErrorMaps().put(errorDetail.getField(), errorDetail.getDefaultMessage());
		}
		return new ResponseEntity<ErrorResponse>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandling(Exception exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(exception.getMessage());
		errorDetails.setStatusCode(500);
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotExistedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(UserNotExistedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(401);
		errorResponse.setDateTime(LocalDateTime.now());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(TrainNotExistedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(TrainNotExistedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(401);
		errorResponse.setDateTime(LocalDateTime.now());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvalidCredentialsException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(401);
		errorResponse.setDateTime(LocalDateTime.now());

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

}
