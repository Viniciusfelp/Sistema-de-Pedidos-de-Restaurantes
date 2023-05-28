package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.DetalhamentoFuncionarioRecord;
import br.com.restaurantordersystem.models.DetalhamentoPedidoRecord;
import br.com.restaurantordersystem.models.FuncionarioRecord;
import br.com.restaurantordersystem.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity criar(@Valid @RequestBody FuncionarioRecord funcionario, UriComponentsBuilder uriBuilder) {
        var funcionarioCadastrado = funcionarioService.criar(funcionario.toFuncionario());
        var uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionarioCadastrado.getCpf()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoFuncionarioRecord(funcionarioCadastrado));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity atualizar(@PathVariable String cpf,  @Valid @RequestBody FuncionarioRecord funcionario) {
        var funcionarioAux = funcionario.toFuncionario();
        if(funcionarioService.existe(cpf)) return ResponseEntity.notFound().build();
        var funcionarioAtualizado = funcionarioService.atualizar(cpf, funcionarioAux);
        return ResponseEntity.ok(new DetalhamentoFuncionarioRecord(funcionarioAtualizado));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity findById(@PathVariable String cpf) {
        var funcionario = funcionarioService.bucarPorId(cpf);
        if(funcionario.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhamentoFuncionarioRecord(funcionario.get()));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable String cpf) {
        if(funcionarioService.existe(cpf)) return ResponseEntity.notFound().build();
        funcionarioService.deletar(cpf);
        return ResponseEntity.ok().build();
    }
}
