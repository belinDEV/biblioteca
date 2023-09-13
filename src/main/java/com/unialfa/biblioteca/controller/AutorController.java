package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Autor;
import com.unialfa.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("autor")
@Controller
public class AutorController {
    @Autowired
    private AutorService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Autor");
        model.addAttribute("listaDeAutor", service.listarTodos());
        return "autor/lista";
    }

    @PostMapping("/salvar")
    public String salva(Autor autor) {
        service.salvar(autor);
        return "redirect:/autor/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Autor autor) {
        model.addAttribute("bemVindo", "Cadastro de Autor");
        return "autor/formulario";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("autor", service.buscarPorId(id));
        return "autor/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/autor/lista";
    }
}


