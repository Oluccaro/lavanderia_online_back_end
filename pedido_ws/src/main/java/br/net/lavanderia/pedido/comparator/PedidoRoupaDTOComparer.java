package br.net.lavanderia.pedido.comparator;

import java.util.Comparator;

import br.net.lavanderia.pedido.DTO.PedidoRoupaDTO;

public class PedidoRoupaDTOComparer implements Comparator<PedidoRoupaDTO>{
  @Override
  public int compare(PedidoRoupaDTO r1, PedidoRoupaDTO r2){
    return r1.getIdCliente().compareTo(r2.getIdCliente());
    //return (r1.getIdCliente() > r2.getIdCliente() ? 1 : r1.getIdCliente() < r2.getIdCliente() ? -1 : 0);
  }
}
