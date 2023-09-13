package com.unialfa.biblioteca.repository;

import com.unialfa.biblioteca.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
