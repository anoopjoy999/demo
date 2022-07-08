package com.example.demo.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.example.demo.config.NaceConstants;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(NaceException.class)
    public ResponseEntity<ExceptionResponse> customHandleNotFound(NaceException exception, HttpServletRequest request) {
		
		ExceptionResponse error = exception.getExceptionResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setExceptionName(NaceConstants.NACE_EXCEPTION);
        error.setStatus(HttpStatus.NOT_FOUND.value());
		error.callerURL(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setTimestamp(LocalDateTime.now());
        error.setError(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setExceptionDesc(exception.getCause()+exception.getMessage()+ExceptionUtils.getStackTrace(exception));
		error.setExceptionName(NaceConstants.EXCEPTION);
		return error;
	}
	

}
