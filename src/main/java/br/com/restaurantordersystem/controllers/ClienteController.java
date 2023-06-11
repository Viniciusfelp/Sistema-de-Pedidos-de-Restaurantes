package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.cliente.Cliente;
import br.com.restaurantordersystem.models.cliente.ClienteRecord;
import br.com.restaurantordersystem.models.cliente.DetalhamentoClienteRecord;
import br.com.restaurantordersystem.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
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
    public ResponseEntity<Page<Cliente>> findAll(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        var clientes = clienteService.findAll(pageable);
        return ResponseEntity.ok(clientes);
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
