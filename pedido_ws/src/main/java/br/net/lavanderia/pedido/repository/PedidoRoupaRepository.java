package br.net.lavanderia.pedido.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.pedido.model.PedidoRoupa;

@Repository
public interface PedidoRoupaRepository  extends JpaRepository<PedidoRoupa, Long>{
}
