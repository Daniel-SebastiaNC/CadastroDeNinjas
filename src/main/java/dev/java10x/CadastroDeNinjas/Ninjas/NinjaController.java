package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Hello World";
    }

    //Adiconar Ninja
    @PostMapping("/adicionar")
    @Operation(summary = "Adicionar Ninja", description = "Essa rota executa a ação de adiconar um ninja no DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja adicionado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possível adiconar o Ninja")
    })
    public ResponseEntity<String> cirarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAdicionado = ninjaService.cirarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja " + ninjaAdicionado.getNome() + " adiconado!");
    }

    //Mostrar todos os Ninjas
    @GetMapping("/todos")
    @Operation(summary = "Lista todos os Ninjas", description = "Essa rota executa a ação de listar todos os ninjas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas encontrado com sucesso")
    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar Ninja por Id
    @GetMapping("/mostrar/{id}")
    @Operation(summary = "Mostrar ninja específico", description = "Essa rota executa a ação de mostrar um ninja específico cadastrado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> mostrarNinjaPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id) {

        NinjaDTO ninja = ninjaService.mostrarNinjaPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");

    }

    //Alterar dados do Ninja
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id,
            @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisiçao")
            @RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO ninja = ninjaService.alterarPorId(id, ninjaDTO);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");
    }

    //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta ninja específico", description = "Essa rota executa a ação de deletar um ninja específico cadastrado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com suacesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<String> deletarPorId(
            @Parameter(description = "Usuario manda o id no caminho da requisiçao")
            @PathVariable Long id) {

        if(mostrarNinjaPorId(id).getStatusCode() == HttpStatus.OK){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com id - " + id + " foi deletado!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com Id - " + id + " não foi encontrado!");
    }

}
