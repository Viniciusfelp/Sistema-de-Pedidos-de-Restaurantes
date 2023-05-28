package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.Produto;
import br.com.restaurantordersystem.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long codigo) {
        return produtoRepository.findById(codigo).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto atualizar (Long codigo, Produto produto) {
        var produtoAux = produtoRepository.findById(codigo).orElse(null);
        if (produtoAux != null) {
            if(produto.getNome() != null) produtoAux.setNome(produto.getNome());
            if(produto.getPreco() != 0) produtoAux.setPreco(produto.getPreco());
            if(produto.getDescricao() != null) produtoAux.setDescricao(produto.getDescricao());
            return produtoRepository.save(produtoAux);
        }
       return null;
    }

    public void deletar (Long codigo) {
        produtoRepository.deleteById(codigo);
    }

    public boolean existe(Long codigo) {
        return !produtoRepository.existsById(codigo);
    }

}
