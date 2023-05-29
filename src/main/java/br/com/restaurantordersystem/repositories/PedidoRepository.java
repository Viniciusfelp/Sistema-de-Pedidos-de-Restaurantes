package br.com.restaurantordersystem.repositories;

import br.com.restaurantordersystem.models.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
