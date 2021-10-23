package br.com.giovanniramos.ticket.exceptions;

import org.springframework.http.HttpStatus;

public class CategoriaNotFoundException extends BaseException {
    public CategoriaNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Categoria não encontrada");
    }
}
