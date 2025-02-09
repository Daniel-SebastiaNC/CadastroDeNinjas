package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    @PostMapping("/adiconar")
    public String criarMissao(){
        return "Missao Criada";
    }

    @GetMapping("/todos")
    public String mostrarTodos(){
        return "Todas Missoes";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrarPorId(){
        return "Missao por id";
    }

    @PutMapping("/alterar/{id}")
    public String alterarPorId(){
        return "Altera por id";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletaPorId(){
        return "Deleta por id";
    }
}
