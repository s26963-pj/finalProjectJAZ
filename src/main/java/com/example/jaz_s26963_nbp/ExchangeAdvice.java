package com.example.jaz_s26963_nbp;

import com.example.jaz_s26963_nbp.exceptions.ExchangeNotFoundException;
import com.example.jaz_s26963_nbp.exceptions.ExchangeNotFoundInNbpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExchangeAdvice {

    @ExceptionHandler(ExchangeNotFoundException.class)
    public ResponseEntity<String> exchangeNotFoundException(ExchangeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request. Exception message: " + ex.getLocalizedMessage());
    }

    @ExceptionHandler(ExchangeNotFoundInNbpException.class)
    public ResponseEntity<String> exchangeNotFoundInNbpException(ExchangeNotFoundInNbpException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Exception occured on request. Exception message: " + ex.getLocalizedMessage());
    }
}
