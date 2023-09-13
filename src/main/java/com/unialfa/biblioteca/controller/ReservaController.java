package com.unialfa.biblioteca.controller;

import com.unialfa.biblioteca.model.Reserva;
import com.unialfa.biblioteca.service.AlunoService;
import com.unialfa.biblioteca.service.LivroService;
import com.unialfa.biblioteca.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("reserva")
@Controller
public class
ReservaController {
    @Autowired
    private ReservaService service;
    @Autowired
    private LivroService livroservice;
    @Autowired
    private AlunoService alunoservice;


    @GetMapping("/lista")
    public String iniciarLista(Model model) {
        model.addAttribute("boasVindas", "Lista de Reservas");
        model.addAttribute("listaDeReserva", service.listarTodos());
        return "reserva/lista";
    }

    @PostMapping("/salvar")
    public String salva(Reserva reserva) {
        service.salvar(reserva);
        return "redirect:/reserva/lista";
    }

    @GetMapping("/formulario")
    public String iniciarFormulario(Model model, Reserva reserva) {
        model.addAttribute("bemVindo", "Cadastro de Reserva");
        model.addAttribute("listaDeAluno", alunoservice.listarTodos());
        model.addAttribute("listaDeLivro", livroservice.listarTodos());
        return "reserva/formulario";
    }


    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable Long id, Model model) {
        model.addAttribute("reserva", service.buscarPorId(id));
        model.addAttribute("listaDeAluno",
                alunoservice.listarTodos());
        model.addAttribute("listaDeLivro",
                livroservice.listarTodos());
        return "reserva/formulario";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable Long id) {
        service.removerPorId(id);
        return "redirect:/reserva/lista";
    }
}


