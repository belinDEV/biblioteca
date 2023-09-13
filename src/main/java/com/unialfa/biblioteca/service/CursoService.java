package com.unialfa.biblioteca.service;


import com.unialfa.biblioteca.model.Curso;
import com.unialfa.biblioteca.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

    @Service
    public class CursoService {

        @Autowired
        private CursoRepository repository;

        public Curso salvar(Curso curso){
            return repository.save(curso);
        }

        public List<Curso> listarTodos(){
            return repository.findAll();
        }

        public Curso buscarPorId(Long id) {
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
