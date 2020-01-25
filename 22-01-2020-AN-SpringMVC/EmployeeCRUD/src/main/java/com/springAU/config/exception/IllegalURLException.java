package com.springAU.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Illegal URL")
public class IllegalURLException extends RuntimeException {

}
