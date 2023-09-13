package com.unialfa.biblioteca.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String titulo;

    private String subTitulo;

    private String isbn;

    private String local;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ano;
    //@DateTimeFormat(pattern="dd/MM/yyyy")

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editora editora;

    @Override
    public String toString() {
        return id +"-"+ titulo;
    }
}
