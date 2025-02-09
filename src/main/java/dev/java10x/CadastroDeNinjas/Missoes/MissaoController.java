package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {
    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/adiconar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao){
        return missaoService.criarMissao(missao);
    }

    @GetMapping("/todos")
    public List<MissaoModel> mostrarTodos(){
        return missaoService.mostrarTodos();
    }

    @GetMapping("/mostrar/{id}")
    public MissaoModel mostrarPorId(@PathVariable Long id){
        return missaoService.mostrarPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissaoModel alterarPorId(@PathVariable Long id, @RequestBody MissaoModel missao){
        return missaoService.alterarPorId(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletaPorId(@PathVariable Long id){
        missaoService.deletaPorId(id);
    }
}
