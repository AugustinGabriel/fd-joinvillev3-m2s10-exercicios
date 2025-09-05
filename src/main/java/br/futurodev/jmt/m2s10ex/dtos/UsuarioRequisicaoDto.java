package br.futurodev.jmt.m2s10ex.dtos;

import br.futurodev.jmt.m2s10ex.enums.Perfil;

public record UsuarioRequisicaoDto(
        String nome,
        String nomeUsuario,
        String senha,
        Perfil perfil
) {
}
