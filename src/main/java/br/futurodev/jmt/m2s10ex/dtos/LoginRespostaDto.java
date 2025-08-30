package br.futurodev.jmt.m2s10ex.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRespostaDto {

    private String tipo;
    private String token;

}
