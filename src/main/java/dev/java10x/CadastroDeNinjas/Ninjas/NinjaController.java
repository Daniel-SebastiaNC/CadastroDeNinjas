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
    public NinjaDTO cirarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.cirarNinja(ninja);
    }

    //Mostrar todos os Ninjas
    @GetMapping("/todos")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninja por Id
    @GetMapping("/mostrar/{id}")
    public NinjaDTO mostrarNinjaPorId(@PathVariable Long id) {
        return ninjaService.mostrarNinjaPorId(id);
    }

    //Alterar dados do Ninja
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.alterarPorId(id, ninjaDTO);
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }

}
