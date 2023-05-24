package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
