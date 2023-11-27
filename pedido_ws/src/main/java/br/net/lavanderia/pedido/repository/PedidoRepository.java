package br.net.lavanderia.pedido.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.pedido.model.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
  public Pedido save(Pedido pedido);  
}
