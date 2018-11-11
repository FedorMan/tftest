package com.tftest.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for responce 404 not found
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
public class ResourceNotFoundException extends RuntimeException {
}
