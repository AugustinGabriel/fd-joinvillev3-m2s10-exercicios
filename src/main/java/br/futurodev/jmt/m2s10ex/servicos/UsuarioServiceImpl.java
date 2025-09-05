package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.dtos.UsuarioRequisicaoDto;
import br.futurodev.jmt.m2s10ex.dtos.UsuarioRespostaDto;
import br.futurodev.jmt.m2s10ex.entidades.UsuarioEntity;
import br.futurodev.jmt.m2s10ex.enums.Perfil;
import br.futurodev.jmt.m2s10ex.mapeadores.UsuarioMapper;
import br.futurodev.jmt.m2s10ex.repositorios.UsuarioRepository;
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
public class UsuarioServiceImpl implements UsuarioService {

    private static final String NOME_USUARIO_PADRAO = "raiz";
    private static final String SENHA_USUARIO_PADRAO = "123";

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuario = repository.findByNomeUsuario(username);
        if (usuario.isPresent()) {
            return usuario.get();
        }

        if (NOME_USUARIO_PADRAO.equals(username)) {
            String senhaPadraoCriptografada = passwordEncoder.encode(SENHA_USUARIO_PADRAO);
            return UsuarioEntity.builder()
                    .id(0L)
                    .nome("Raiz")
                    .nomeUsuario(NOME_USUARIO_PADRAO)
                    .senha(senhaPadraoCriptografada)
                    .perfil(Perfil.ADMIN)
                    .build();
        }

        throw new RuntimeException("Usuário não encontrado!");
    }

    @Override
    public UsuarioRespostaDto buscarPorId(Long id) {
        return buscarEntidadePorId(id)
                .map(UsuarioMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<UsuarioRespostaDto> buscarTodos() {
        return repository.findAll()
                .stream().map(UsuarioMapper::toDto)
                .toList();
    }

    @Override
    public UsuarioRespostaDto criar(UsuarioRequisicaoDto dto) {
        return salvar(new UsuarioEntity(), dto);
    }

    @Override
    public UsuarioRespostaDto alterar(Long id, UsuarioRequisicaoDto dto) {
        UsuarioEntity entidade = buscarEntidadePorId(id).orElseThrow();
        return salvar(entidade, dto);
    }

    @Override
    public void excluir(Long id) {
        UsuarioEntity entidade = buscarEntidadePorId(id).orElseThrow();
        repository.delete(entidade);
    }

    private Optional<UsuarioEntity> buscarEntidadePorId(Long id) {
        return repository.findById(id);
    }

    private UsuarioRespostaDto salvar(UsuarioEntity entidade, UsuarioRequisicaoDto dto) {
        UsuarioMapper.toEntity(entidade, dto);

        if (
                entidade.getId() == null || // Criação
                (entidade.getId() != null && StringUtils.hasText(dto.senha())) // Edição
        ) {
            String senha = passwordEncoder.encode(dto.senha());
            entidade.setSenha(senha);
        }

        repository.save(entidade);
        return UsuarioMapper.toDto(entidade);
    }

}
