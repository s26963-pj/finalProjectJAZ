package com.example.jaz_s26963_nbp.exceptions;

public class ExchangeNotFoundException extends RuntimeException{
    public ExchangeNotFoundException() {
        super("Exchange with that data has not been found");
    }
}
