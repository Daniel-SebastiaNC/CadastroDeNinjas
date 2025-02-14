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
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO){
        return missaoService.criarMissao(missaoDTO);
    }

    @GetMapping("/todos")
    public List<MissaoDTO> mostrarTodos(){
        return missaoService.mostrarTodos();
    }

    @GetMapping("/mostrar/{id}")
    public MissaoDTO mostrarPorId(@PathVariable Long id){
        return missaoService.mostrarPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarPorId(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return missaoService.alterarPorId(id, missaoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletaPorId(@PathVariable Long id){
        missaoService.deletaPorId(id);
    }
}
