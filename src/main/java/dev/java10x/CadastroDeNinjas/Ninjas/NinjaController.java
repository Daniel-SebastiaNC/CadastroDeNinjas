package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/hello")
    public String boasVindas(){
        return "Hello World";
    }

    //Adiconar Ninja
    @PostMapping("/adicionar")
    public String cirarNinja() {
        return "Ninja adicionado";
    }

    //Mostrar todos os Ninjas
    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Todos os Ninja";
    }

    //Mostrar Ninja por Id
    @GetMapping("/todos/{id}")
    public String mostrarNinjasPorId() {
        return "Todos os Ninja por id";
    }

    //Alterar dados do Ninja
    @PutMapping("/alterar/{id}")
    public String alterarPorId() {
        return "Alterar os Ninja por id";
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public String deletarPorId() {
        return "Deletar os Ninja por id";
    }

}
