package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/hello")
    public String boasVindas(){
        return "Hello World";
    }

    //Adiconar Ninja
    @PostMapping("/adicionar")
    public ResponseEntity<String> cirarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAdicionado = ninjaService.cirarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninjaAdicionado.getNome() + " adiconado!");
    }

    //Mostrar todos os Ninjas
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar Ninja por Id
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.mostrarNinjaPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");

    }

    //Alterar dados do Ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.alterarPorId(id, ninjaDTO);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if(mostrarNinjaPorId(id).getStatusCode() == HttpStatus.OK){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com id - " + id + " foi deletado!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");
    }

}
