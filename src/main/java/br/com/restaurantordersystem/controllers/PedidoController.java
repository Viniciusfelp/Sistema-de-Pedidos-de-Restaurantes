package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.PedidoRecord;
import br.com.restaurantordersystem.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity criar(@Valid @RequestBody PedidoRecord pedido, UriComponentsBuilder uriBuilder){
        var pedidoCadastrado = pedidoService.criar(pedido.toPedido());
        var uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedidoCadastrado.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(pedidoCadastrado);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity findById(@PathVariable Long codigo) {
        var pedido = pedidoService.findById(codigo);
        if(pedido == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity atualizar(@PathVariable Long codigo, @Valid @RequestBody PedidoRecord pedido) {
        var pedidoAux = pedido.toPedido();
        if(pedidoService.existe(codigo)) return ResponseEntity.notFound().build();
        var pedidoAtualizado = pedidoService.atualizar(codigo, pedidoAux);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if(pedidoService.existe(codigo)) return ResponseEntity.notFound().build();
        pedidoService.deletar(codigo);
        return ResponseEntity.ok().build();
    }
}
