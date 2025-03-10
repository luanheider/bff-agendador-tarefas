package com.luanheider.bff_agendador_tarefas.infrastructure.client.config;

import com.luanheider.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import com.luanheider.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import com.luanheider.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.luanheider.bff_agendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 409 -> new ConflictException("Erro atributo já existente");
            case 403 -> new ResourceNotFoundException("Erro atributo não encontrado");
            case 401 -> new UnauthorizedException("Erro usuário não autorizado");
            default -> new BusinessException("Erro de servidor");
        };
    }
}