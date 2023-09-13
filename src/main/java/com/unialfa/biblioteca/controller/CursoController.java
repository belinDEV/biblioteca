package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Curso;
import com.unialfa.biblioteca.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("curso")
@Controller
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Cursos");
        model.addAttribute("listaDeCursos", service.listarTodos());
        return "curso/lista";
    }

    @PostMapping("/salvar")
    public String salva(Curso curso) {
        service.salvar(curso);
        return "redirect:/curso/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Curso curso) {
        model.addAttribute("bemVindo", "Cadastro de Cursos");
        return "curso/formulario";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("curso", service.buscarPorId(id));
        return "curso/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/curso/lista";
    }
}


