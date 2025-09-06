package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.OrganizacaoRespostaDto;
import br.futurodev.jmt.m2s10ex.entidades.OrganizacaoEntity;
import br.futurodev.jmt.m2s10ex.enums.Perfil;
import br.futurodev.jmt.m2s10ex.mapeadores.OrganizacaoMapper;
import br.futurodev.jmt.m2s10ex.repositorios.OrganizacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizacaoServiceImpl implements OrganizacaoService {

    private final OrganizacaoRepository repository;

    @Override
    public OrganizacaoRespostaDto buscarPorId(Long id) {
        return buscarEntidadePorId(id)
                .map(OrganizacaoMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<OrganizacaoRespostaDto> buscarTodos() {
        return repository.findAll()
                .stream().map(OrganizacaoMapper::toDto)
                .toList();
    }

    @Override
    public OrganizacaoRespostaDto criar(OrganizacaoRequisicaoDto dto) {
        return salvar(new OrganizacaoEntity(), dto);
    }

    @Override
    public OrganizacaoRespostaDto alterar(Long id, OrganizacaoRequisicaoDto dto) {
        OrganizacaoEntity entidade = buscarEntidadePorId(id).orElseThrow();
        return salvar(entidade, dto);
    }

    @Override
    public void excluir(Long id) {
        OrganizacaoEntity entidade = buscarEntidadePorId(id).orElseThrow();
        repository.delete(entidade);
    }

    private Optional<OrganizacaoEntity> buscarEntidadePorId(Long id) {
        return repository.findById(id);
    }

    private OrganizacaoRespostaDto salvar(OrganizacaoEntity entidade, OrganizacaoRequisicaoDto dto) {
        OrganizacaoMapper.toEntity(entidade, dto);

        repository.save(entidade);
        return OrganizacaoMapper.toDto(entidade);
    }

}
