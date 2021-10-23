package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class EventoNotFoundException extends BaseException {

    public EventoNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Eventos não encontrados");
    }
}
