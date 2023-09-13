package com.unialfa.biblioteca.service;


import com.unialfa.biblioteca.model.Editora;
import com.unialfa.biblioteca.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository repository;

    public Editora salvar(Editora editora){
        return repository.save(editora);
    }

    public List<Editora> listarTodos(){
        return repository.findAll();
    }

    public Editora buscarPorId(Long id) {
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
