package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRespostaDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface OrganizacaoService {

    OrganizacaoRespostaDto buscarPorId(Long id);
    List<OrganizacaoRespostaDto> buscarTodos();

    OrganizacaoRespostaDto criar(OrganizacaoRequisicaoDto dto);
    OrganizacaoRespostaDto alterar(Long id, OrganizacaoRequisicaoDto dto);

    void excluir(Long id);

}
