package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.pedido.DetalhamentoPedidoRecord;
import br.com.restaurantordersystem.models.pedido.PedidoRecord;
import br.com.restaurantordersystem.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        return ResponseEntity.created(uri).body(new DetalhamentoPedidoRecord(pedidoCadastrado));
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"cliente"}) Pageable pageable){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity findById(@PathVariable Long codigo) {
        var pedido = pedidoService.findById(codigo);
        if(pedido == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhamentoPedidoRecord(pedido));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity atualizar(@PathVariable Long codigo, @Valid @RequestBody PedidoRecord pedido) {
        var pedidoAux = pedido.toPedido();
        if(pedidoService.existe(codigo)) return ResponseEntity.notFound().build();
        var pedidoAtualizado = pedidoService.atualizar(codigo, pedidoAux);
        return ResponseEntity.ok(new DetalhamentoPedidoRecord(pedidoAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if(pedidoService.existe(codigo)) return ResponseEntity.notFound().build();
        pedidoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }
}
