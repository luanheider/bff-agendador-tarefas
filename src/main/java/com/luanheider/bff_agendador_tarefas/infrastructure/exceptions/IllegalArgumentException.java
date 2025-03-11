package com.luanheider.bff_agendador_tarefas.infrastructure.exceptions;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
