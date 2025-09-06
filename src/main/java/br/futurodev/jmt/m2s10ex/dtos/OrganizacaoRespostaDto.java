package br.futurodev.jmt.m2s10ex.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizacaoRespostaDto {

    private Long id;
    private String nome;
    private String contato;

}
