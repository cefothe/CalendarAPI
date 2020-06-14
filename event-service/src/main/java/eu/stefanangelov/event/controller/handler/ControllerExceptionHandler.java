package eu.stefanangelov.event.controller.handler;

import eu.stefanangelov.event.services.exception.EventConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EventConflictException.class)
    public ResponseEntity<String> handleEventConflictException(Exception ex){
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
}
