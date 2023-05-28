package br.com.restaurantordersystem.services;

import br.com.restaurantordersystem.models.Pedido;
import br.com.restaurantordersystem.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long codigo) {
        return pedidoRepository.findById(codigo).orElse(null);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido atualizar (Long codigo, Pedido pedido) {
        var pedidoAux = pedidoRepository.findById(codigo).orElse(null);
        if (pedidoAux != null) {
            if(pedido.getCliente() != null) pedidoAux.setCliente(pedido.getCliente());
            if(pedido.getFuncionario() != null) pedidoAux.setFuncionario(pedido.getFuncionario());
            if(pedido.getProdutos() != null) pedidoAux.setProdutos(pedido.getProdutos());
            return pedidoRepository.save(pedidoAux);
        }
       return null;
    }

    public void deletar (Long codigo) {
        pedidoRepository.deleteById(codigo);
    }

    public boolean existe(Long codigo) {
        return !pedidoRepository.existsById(codigo);
    }

    public Pedido findById(Long codigo) {
        return pedidoRepository.findById(codigo).orElse(null);
    }
}
