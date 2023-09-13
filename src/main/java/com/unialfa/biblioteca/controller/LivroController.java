package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Livro;

import com.unialfa.biblioteca.service.AutorService;
import com.unialfa.biblioteca.service.EditoraService;
import com.unialfa.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("livro")
@Controller
public class
LivroController {
    @Autowired
    private LivroService service;
    @Autowired
    private EditoraService editoraservice;
    @Autowired
    private AutorService autorservice;
    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Livros");
        model.addAttribute("listaDeLivro", service.listarTodos());
        return "livro/lista";
    }

    @PostMapping("/salvar")
    public String salva(Livro livro) {
        service.salvar(livro);
        return "redirect:/livro/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Livro livro) {
        model.addAttribute("bemVindo", "Cadastro de Livro");
        model.addAttribute("listaDeEditora", editoraservice.listarTodos());
        model.addAttribute("listaDeAutor", autorservice.listarTodos());
        return "livro/formulario";
    }


    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("livro", service.buscarPorId(id));
        model.addAttribute("listaDeEditora",
                editoraservice.listarTodos());
        model.addAttribute("listaDeAutor",
                autorservice.listarTodos());
        return "livro/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/livro/lista";
    }
}


