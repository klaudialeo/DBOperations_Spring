package de.dbsystel.operations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Collection of exception handlers
 */
@ControllerAdvice
public class ControllerAdvisor {

    /**
     * Fired when the requested page is not mapped / found
     * @return status code not found (404) and its corresponding response body message
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Object> handleNoHandlerFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - Seite nicht gefunden");
    }

    /**
     * Fired when there are any other errors
     * @return status code not found (404) and its corresponding response body message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Leider gab es einen Fehler");
    }
}
