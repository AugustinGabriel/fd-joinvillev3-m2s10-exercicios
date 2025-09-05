package br.futurodev.jmt.m2s10ex.dtos;

import br.futurodev.jmt.m2s10ex.enums.Perfil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRespostaDto {

    private Long id;
    private String nome;
    private String nomeUsuario;
    private Perfil perfil;

}
