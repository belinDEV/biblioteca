package com.unialfa.biblioteca.service;
import com.unialfa.biblioteca.model.Reserva;
import com.unialfa.biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    public Reserva salvar(Reserva reserva){
        return repository.save(reserva);
    }

    public List<Reserva> listarTodos(){
        return repository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public void removerPorId(Long id) {
        try {
            repository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
