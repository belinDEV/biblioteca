package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Editora;
import com.unialfa.biblioteca.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("editora")
@Controller
public class EditoraController {
    @Autowired
    private EditoraService service;

    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Editoras");
        model.addAttribute("listaDeEditora", service.listarTodos());
        return "editora/lista";
    }

    @PostMapping("/salvar")
    public String salva(Editora editora) {
        service.salvar(editora);
        return "redirect:/editora/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Editora editora) {
        model.addAttribute("bemVindo", "Cadastro de Editoras" +
                "");
        return "editora/formulario";
    }

    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("editora", service.buscarPorId(id));
        return "editora/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/editora/lista";
    }
}


