package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.funcionario.DetalhamentoFuncionarioRecord;
import br.com.restaurantordersystem.models.funcionario.FuncionarioRecord;
import br.com.restaurantordersystem.services.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(funcionarioService.findAll(pageable));
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
        return ResponseEntity.noContent().build();
    }
}
