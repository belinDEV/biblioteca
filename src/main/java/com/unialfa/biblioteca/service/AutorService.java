package com.unialfa.biblioteca.service;

import com.unialfa.biblioteca.model.Autor;
import com.unialfa.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos(){
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return autorRepository.findById(id).get();
    }

    public void removerPorId(Long id) {
        try {
            autorRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
