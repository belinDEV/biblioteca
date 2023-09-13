package com.unialfa.biblioteca.service;

import com.unialfa.biblioteca.model.Aluno;
import com.unialfa.biblioteca.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).get();
    }

    public void removerPorId(Long id) {
        try {
            alunoRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
