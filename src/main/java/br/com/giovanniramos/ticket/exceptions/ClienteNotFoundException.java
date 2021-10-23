package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends BaseException{

    public ClienteNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
