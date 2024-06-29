package com.example.jaz_s26963_nbp.exceptions;

public class ExchangeNotFoundInNbpException extends RuntimeException{
    public ExchangeNotFoundInNbpException() {
        super("Exchange with that code has not been found");
    }
}
