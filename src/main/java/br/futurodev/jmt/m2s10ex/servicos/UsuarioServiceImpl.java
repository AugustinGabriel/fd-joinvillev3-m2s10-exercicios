package br.futurodev.jmt.m2s10ex.servicos;

import br.futurodev.jmt.m2s10ex.entidades.UsuarioEntity;
import br.futurodev.jmt.m2s10ex.enums.Perfil;
import br.futurodev.jmt.m2s10ex.repositorios.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

}
