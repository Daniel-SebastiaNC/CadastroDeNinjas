package dev.java10x.CadastroDeNinjas.Missao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MissaoDTO> criarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO missaoAdiconada = missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(missaoAdiconada);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<MissaoDTO>> mostrarTodos(){
        List<MissaoDTO> missoes = missaoService.mostrarTodos();
        return ResponseEntity.ok().body(missoes);
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id){
        MissaoDTO missaoDTO = missaoService.mostrarPorId(id);
        if (missaoDTO != null) {
            return ResponseEntity.ok().body(missaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com Id " + id + " não foi encontrado!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorId(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        MissaoDTO missaoAltareda = missaoService.alterarPorId(id, missaoDTO);
        if (missaoAltareda != null) {
            return ResponseEntity.ok().body(missaoAltareda);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com Id " + id + " não foi encontrado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletaPorId(@PathVariable Long id){
        MissaoDTO missaoDTO = missaoService.mostrarPorId(id);
        if (missaoDTO != null) {
            missaoService.deletaPorId(id);
            return ResponseEntity.ok().body("Missao com Id " + id + " foi deletada!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com Id " + id + " não foi encontrado!");

    }
}
