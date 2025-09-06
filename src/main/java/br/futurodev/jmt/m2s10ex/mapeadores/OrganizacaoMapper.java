package br.futurodev.jmt.m2s10ex.mapeadores;

import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRespostaDto;
import br.futurodev.jmt.m2s10ex.entidades.OrganizacaoEntity;

public class OrganizacaoMapper {

    /** Construtor privado para evitar a criação de instâncias ("new OrganizacaoMapper()") */
    private OrganizacaoMapper() {}

    public static OrganizacaoRespostaDto toDto(OrganizacaoEntity entidade) {
        return OrganizacaoRespostaDto.builder()
                .id(entidade.getId())
                .nome(entidade.getNome())
                .contato(entidade.getContato())
                .build();
    }

    public static OrganizacaoEntity toEntity(OrganizacaoRequisicaoDto dto) {
        return toEntity(new OrganizacaoEntity(), dto);
    }

    public static OrganizacaoEntity toEntity(OrganizacaoEntity entidade, OrganizacaoRequisicaoDto dto) {
        entidade.setNome(dto.nome());
        entidade.setContato(dto.contato());

        return entidade;
    }

}
