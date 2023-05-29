package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.Cliente;
import br.com.restaurantordersystem.models.ClienteRecord;
import br.com.restaurantordersystem.models.DetalhamentoClienteRecord;
import br.com.restaurantordersystem.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity criarUsuario(@Valid @RequestBody ClienteRecord cliente, UriComponentsBuilder uriBuilder) {
        var usuarioCadastrado = clienteService.criar(cliente.toCliente());
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioCadastrado.getCpf()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoClienteRecord(usuarioCadastrado));
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity atualizarUsuario(@PathVariable String cpf, @Valid @RequestBody ClienteRecord usuario) {
        var usuarioAux = usuario.toCliente();
        if(clienteService.existe(cpf)) return ResponseEntity.notFound().build();
        var usuarioAtualizado = clienteService.atualizar(usuarioAux);
        return ResponseEntity.ok(new DetalhamentoClienteRecord(usuarioAtualizado));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarUsuario(@PathVariable String cpf) {
        if(clienteService.existe(cpf)) return ResponseEntity.notFound().build();
        clienteService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity buscarUsuarioPorId(@PathVariable String cpf) {
        var usuario = clienteService.buscarPorId(cpf);
        if(usuario == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhamentoClienteRecord(usuario));
    }
}
