package com.progressoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.progressoft.service.validation.ValidationException;

@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger log;

	@ExceptionHandler({ ValidationException.class })
	@ResponseBody
	public ResponseEntity validationExceptionHandler(final ValidationException e) {
		ControllerExceptionHandler.log.error("System Exception", (Throwable) e);
		return ResponseEntity.badRequest().body((Object) e.getMessage());
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity genericExceptionHandler(final Exception e) {
		ControllerExceptionHandler.log.error("Generic Exception", (Throwable) e);
		return ResponseEntity.badRequest().body((Object) "Internal Server Error");
	}

	static {
		log = LoggerFactory.getLogger((Class) ControllerExceptionHandler.class);
	}
}