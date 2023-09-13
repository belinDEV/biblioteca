package com.unialfa.biblioteca.repository;

import com.unialfa.biblioteca.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
