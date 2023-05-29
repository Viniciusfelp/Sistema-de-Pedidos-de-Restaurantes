package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
