package com.unialfa.biblioteca.repository;

import com.unialfa.biblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
