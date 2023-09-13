package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Aluno;
import com.unialfa.biblioteca.service.AlunoService;
import com.unialfa.biblioteca.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("aluno")
@Controller
public class AlunoController {
    @Autowired
    private AlunoService service;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Alunos");
        model.addAttribute("listaDeAlunos", service.listarTodos());
        return "aluno/lista";
    }

    @PostMapping("/salvar")
    public String salva(Aluno aluno) {
        service.salvar(aluno);
        return "redirect:/aluno/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Aluno aluno) {
        model.addAttribute("bemVindo", "Cadastro de Aluno");
        model.addAttribute("listaDeCursos", cursoService.listarTodos());
        return "aluno/formulario";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", service.buscarPorId(id));
        model.addAttribute("listaDeCursos",
                cursoService.listarTodos());
        return "aluno/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/aluno/lista";
    }
}


