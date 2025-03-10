package com.luanheider.bff_agendador_tarefas.business;

import com.luanheider.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.luanheider.bff_agendador_tarefas.business.dto.out.TarefaDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {
    private final TarefaService tarefaService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaMaisCincoMinutos = LocalDateTime.now().plusHours(1).plusMinutes(5);
        List<TarefaDTOResponse> listaTarefa = tarefaService.buscarTarefasAgendadasPorPeriodo(
                horaFutura, horaFuturaMaisCincoMinutos, token);

        listaTarefa.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            tarefaService.alterarStatusDaTarefa(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(), token);
        });
    }

    public String login(LoginRequestDTO loginRequestDTO) {
        return usuarioService.loginUsuario(loginRequestDTO);
    }

    public LoginRequestDTO converterParaRequestDTO() {
        return LoginRequestDTO.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}