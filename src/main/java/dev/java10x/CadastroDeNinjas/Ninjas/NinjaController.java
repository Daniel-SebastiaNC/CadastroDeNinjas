package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/hello")
    public String boasVindas(){
        return "Hello World";
    }

    //Adiconar Ninja
    @PostMapping("/adicionar")
    public NinjaModel cirarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.cirarNinja(ninja);
    }

    //Mostrar todos os Ninjas
    @GetMapping("/todos")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por Id
    @GetMapping("/mostrar/{id}")
    public NinjaModel mostrarNinjaPorId(@PathVariable Long id) {
        return ninjaService.mostrarNinjaPorId(id);
    }

    //Alterar dados do Ninja
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarPorId(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.alterarPorId(id, ninja);
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }

}
