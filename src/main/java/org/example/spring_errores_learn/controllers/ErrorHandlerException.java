package org.example.spring_errores_learn.controllers;

import org.example.spring_errores_learn.models.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

@RestControllerAdvice
public class ErrorHandlerException {



    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDTO> byZeroDivision( Exception e) {

        ErrorDTO error = new ErrorDTO();
        error.setError(String.valueOf(ArithmeticException.class));
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(e.getMessage());
        error.setDate(new Date());

        return  ResponseEntity.ok().body( error );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public  ResponseEntity<ErrorDTO> notFoundEx( Exception e) {
        ErrorDTO error = new ErrorDTO();
        error.setError(String.valueOf("Not Found"));
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setDate(new Date());

        return  ResponseEntity.status(404).body( error );
    }

}
