package br.com.restaurantordersystem.controllers;

import br.com.restaurantordersystem.models.DetalhamentoProdutoRecord;
import br.com.restaurantordersystem.models.ProdutoRecord;
import br.com.restaurantordersystem.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity criar(@RequestBody ProdutoRecord produto, UriComponentsBuilder uriBuilder){
        var produtoAux = produtoService.criar(produto.toProduto());
        var uri = uriBuilder.path("/produto/{codigo}").buildAndExpand(produtoAux.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(produtoAux);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity findById(@PathVariable Long codigo) {
        var produto = produtoService.buscarPorId(codigo);
        if(produto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalhamentoProdutoRecord(produto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity atualizar(@PathVariable Long codigo, @Valid @RequestBody ProdutoRecord produto) {
        var produtoAux = produto.toProduto();
        if(produtoService.existe(codigo)) return ResponseEntity.notFound().build();
        var produtoAtualizado = produtoService.atualizar(codigo, produtoAux);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if(produtoService.existe(codigo)) return ResponseEntity.notFound().build();
        produtoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }

}
