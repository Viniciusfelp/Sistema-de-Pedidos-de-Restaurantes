package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.UsuarioRecord;
import br.com.restaurantordersystem.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity criarUsuario(@Valid @RequestBody UsuarioRecord usuario, UriComponentsBuilder uriBuilder) {
        var usuarioAux = usuario.toUsuario();
        var usuarioCadastrado = usuarioService.criarUsuario(usuarioAux);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioCadastrado.getCpf()).toUri();
        return ResponseEntity.created(uri).body(usuarioCadastrado);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity atualizarUsuario(@PathVariable String cpf, @Valid @RequestBody UsuarioRecord usuario) {
        var usuarioAux = usuario.toUsuario();
        if(usuarioService.usuarioExiste(cpf)) return ResponseEntity.notFound().build();
        var usuarioAtualizado = usuarioService.atualizar(usuarioAux);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarUsuario(@PathVariable String cpf) {
        if(usuarioService.usuarioExiste(cpf)) return ResponseEntity.notFound().build();
        usuarioService.deletar(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity buscarUsuarioPorId(@PathVariable String cpf) {
        var usuario = usuarioService.buscarUsuarioPorId(cpf);
        if(usuario == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuario);
    }
}
