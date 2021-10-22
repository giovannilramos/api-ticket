package br.com.giovanniramos.ticket.exceptions;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public abstract class BaseException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
