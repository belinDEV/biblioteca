package com.unialfa.biblioteca.service;
import com.unialfa.biblioteca.model.Livro;
import com.unialfa.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }

    public List<Livro> listarTodos(){
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
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
