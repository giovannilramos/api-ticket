package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class TicketNotFoundException extends BaseException {

    public TicketNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Ticket not found");
    }
}
