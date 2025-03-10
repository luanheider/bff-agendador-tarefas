package com.luanheider.bff_agendador_tarefas.infrastructure.client;


import com.luanheider.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.luanheider.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                           @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/{email}")
    void deletarUsuarioPorEmail(@PathVariable String email,
                                @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse autalizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                           @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                        @RequestHeader("Authorization") String token);
}