package com.luanheider.bff_agendador_tarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTOResponse {
    private String id;
    private String numero;
    private String ddd;
}
