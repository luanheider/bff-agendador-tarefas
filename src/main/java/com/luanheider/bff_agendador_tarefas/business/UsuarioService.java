package com.luanheider.bff_agendador_tarefas.business;

import com.luanheider.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import com.luanheider.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.luanheider.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.luanheider.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.luanheider.bff_agendador_tarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO) {
        return usuarioClient.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deleteUsuarioPorEmail(String email, String token) {
        usuarioClient.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest usuarioDTO) {
        return usuarioClient.autalizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long id, EnderecoDTORequest enderecoDTO, String token) {
        return usuarioClient.atualizaEndereco(enderecoDTO, id, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long id, TelefoneDTORequest telefoneDTO, String token) {
        return usuarioClient.atualizaTelefone(telefoneDTO, id, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest enderecoDTO) {
        return usuarioClient.cadastraEndereco(enderecoDTO, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest telefoneDTO) {
        return usuarioClient.cadastraTelefone(telefoneDTO, token);
    }
}