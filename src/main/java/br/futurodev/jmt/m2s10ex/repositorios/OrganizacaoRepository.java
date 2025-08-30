package br.futurodev.jmt.m2s10ex.repositorios;

import br.futurodev.jmt.m2s10ex.entidades.OrganizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacaoRepository extends JpaRepository<OrganizacaoEntity, Long> {
}
