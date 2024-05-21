package com.marcos.sigeb.configuration.exceptions;

import com.marcos.sigeb.handlers.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest request) {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var status = HttpStatus.NOT_FOUND;
        var body = new ResponseError();

        body.setCode(status.value());
        body.setDescription(resourceNotFoundException.getMessage());

        return handleExceptionInternal(resourceNotFoundException, body, headers, status, request);
    }
}
