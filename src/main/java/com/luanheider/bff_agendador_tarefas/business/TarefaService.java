package com.luanheider.bff_agendador_tarefas.business;

import com.luanheider.bff_agendador_tarefas.business.dto.in.TarefaDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.out.TarefaDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.luanheider.bff_agendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasClient tarefasClient;

    public TarefaDTOResponse gravarTarefa(String token, TarefaDTORequest tarefaDTO) {
        return tarefasClient.gravarTarefa(tarefaDTO, token);
    }

    public List<TarefaDTOResponse> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token) {
        return tarefasClient.buscartarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefaDTOResponse> buscarTarefasPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public void deletarTarefaPorId(String id, String token) {
        tarefasClient.deletarTarefaPorId(id, token);
    }

    public TarefaDTOResponse alterarStatusDaTarefa(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefaDTOResponse updateTarefas(TarefaDTORequest tarefaDTO, String id, String token) {
        return tarefasClient.updateTarefa(tarefaDTO, id, token);
    }
}