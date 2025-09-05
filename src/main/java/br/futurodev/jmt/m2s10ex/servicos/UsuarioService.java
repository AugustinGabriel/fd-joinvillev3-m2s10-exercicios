package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.dtos.UsuarioRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.UsuarioRespostaDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {

    UsuarioRespostaDto buscarPorId(Long id);
    List<UsuarioRespostaDto> buscarTodos();

    UsuarioRespostaDto criar(UsuarioRequisicaoDto dto);
    UsuarioRespostaDto alterar(Long id, UsuarioRequisicaoDto dto);

    void excluir(Long id);

}
