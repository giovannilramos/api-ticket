package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class UpdateDatabaseException extends BaseException {
    public UpdateDatabaseException() {
        super(HttpStatus.REQUEST_TIMEOUT, "Erro ao salvar registro");
    }
}
