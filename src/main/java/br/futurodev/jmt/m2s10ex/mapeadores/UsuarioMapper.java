package br.futurodev.jmt.m2s10ex.mapeadores;

import br.futurodev.jmt.m2s10ex.dtos.UsuarioRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.UsuarioRespostaDto;
import br.futurodev.jmt.m2s10ex.entidades.UsuarioEntity;

public class UsuarioMapper {

    /** Construtor privado para evitar a criação de instâncias ("new UsuarioMapper()") */
    private UsuarioMapper() {}

    public static UsuarioRespostaDto toDto(UsuarioEntity entidade) {
        return UsuarioRespostaDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .nomeUsuario(entidade.getNomeUsuario())
                .perfil(entidade.getPerfil())
                .build();
    }

    public static UsuarioEntity toEntity(UsuarioRequisicaoDto dto) {
        return toEntity(new UsuarioEntity(), dto);
    }

    public static UsuarioEntity toEntity(UsuarioEntity entidade, UsuarioRequisicaoDto dto) {
        entidade.setNome(dto.nome());
        entidade.setNomeUsuario(dto.nomeUsuario());
        entidade.setPerfil(dto.perfil());

        return entidade;
    }

}
