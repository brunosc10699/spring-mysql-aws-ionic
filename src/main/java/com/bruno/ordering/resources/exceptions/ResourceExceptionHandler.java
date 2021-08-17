package com.bruno.ordering.resources.exceptions;

import com.bruno.ordering.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            HttpServletRequest request, ResourceNotFoundException exception
    ){
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "The resource you were looking for was not found!";
        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                exception.getMessage(),
                message,
                request.getRequestURI()
        );
        return ResponseEntity.status(404).body(standardError);
    }
}
