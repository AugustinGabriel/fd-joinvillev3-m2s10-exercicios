package br.futurodev.jmt.m2s10ex.repositorios;

import br.futurodev.jmt.m2s10ex.entidades.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByNomeUsuario(String nomeUsuario);

}
