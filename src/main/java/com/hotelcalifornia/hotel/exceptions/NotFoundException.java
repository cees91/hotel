package com.hotelcalifornia.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * When nothing is found, throw this exception.
 * supports HTTP status 404 Not Found
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(){
        super();
    }
    public NotFoundException(String message, Throwable cause){
        super(message,cause);
    }
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(Throwable cause){
        super(cause);
    }

}
