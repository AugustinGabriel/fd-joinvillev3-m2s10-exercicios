package br.futurodev.jmt.m2s10ex.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "organizacoes")
public class OrganizacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    private String contato;

}
