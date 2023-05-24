package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
