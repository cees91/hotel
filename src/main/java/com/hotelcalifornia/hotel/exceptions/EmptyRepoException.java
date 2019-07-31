package com.hotelcalifornia.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * When a list or table in a repository is empty, throw this exception.
 * supports the HTTP status 204 No Content
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class EmptyRepoException extends RuntimeException{
}
