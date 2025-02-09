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

    @GetMapping("/mostrarporid")
    public String mostrarPorId(){
        return "Missao por id";
    }

    @PutMapping("/alterar")
    public String alterarPorId(){
        return "Altera por id";
    }

    @DeleteMapping
    public String deletaPorId(){
        return "Deleta por id";
    }
}
