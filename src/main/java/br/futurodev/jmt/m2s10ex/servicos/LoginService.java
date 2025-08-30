package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.dtos.LoginRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.LoginRespostaDto;

public interface LoginService {

    LoginRespostaDto autenticar(LoginRequisicaoDto dto);

}
