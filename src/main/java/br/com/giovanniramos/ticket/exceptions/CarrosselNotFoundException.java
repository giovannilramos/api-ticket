package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class CarrosselNotFoundException extends BaseException {
    public CarrosselNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Não encontrado");
    }
}
