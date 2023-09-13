package com.unialfa.biblioteca.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Integer ra;

    private String nome;

    private String endereco;

    private String cidade;

    private String uf;

    private String telefone;
    @ManyToOne
    private Curso curso;


    @Override
    public String toString() {
        return id +"-"+ nome;
    }
}
