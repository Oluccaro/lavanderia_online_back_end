package br.net.lavanderia.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import br.net.lavanderia.pedido.DTO.PedidoRoupaDTO;
import br.net.lavanderia.pedido.DTO.RoupaQtdDTO;
import br.net.lavanderia.pedido.model.Pedido;
import br.net.lavanderia.pedido.model.PedidoRoupa;
import br.net.lavanderia.pedido.model.Roupa;
import br.net.lavanderia.pedido.model.key.PedidoRoupaKey;

public class PedidoRoupaMapper {
  public static void toListPedidoRoupaDTO(PedidoRoupa p, List<PedidoRoupaDTO> lista) {
    boolean update = false;
    Pedido pedido = p.getPedido();
    PedidoRoupaDTO pedRoupaDTO = lista.stream().filter(i -> i.getId() == pedido.getId()).findFirst().orElse(null);
    if(pedRoupaDTO == null){
      update = true;
      pedRoupaDTO = new PedidoRoupaDTO(
        pedido.getId(), 
        pedido.getStatus(), 
        pedido.getValor(), 
        pedido.getDataPedido(), 
        pedido.getDtEntregaPrevista(),
        pedido.getIdCliente() 
      );
    }
    Roupa r = p.getRoupa();
    RoupaQtdDTO roupa = new RoupaQtdDTO(
      r.getId(),
      r.getPreco(),
      r.getPrazo(),
      r.getDescricao(),
      r.getImagemDescr(),
      r.getImagem(),
      p.getQuantidade()
    );
    pedRoupaDTO.addRoupas(roupa);
    if(update){
      lista.add(pedRoupaDTO);
    }
  }

  public static List<PedidoRoupa> toPedidoRoupa(PedidoRoupaDTO ped){
    List<PedidoRoupa> listaPedidoRoupa = new ArrayList<PedidoRoupa>();
    Pedido pedido = new Pedido(ped.getId(),
      ped.getStatus(),
      ped.getValor(),
      ped.getDataPedido(),
      ped.getDtEntregaPrevista(), 
      ped.getIdCliente()
    );
    List<RoupaQtdDTO> ListaRoupa = ped.getRoupas();
    ListaRoupa.stream().forEach(r -> {
      PedidoRoupaKey key = new PedidoRoupaKey(pedido.getId(),r.getId());
      Roupa roupa = new Roupa(
        r.getId(), 
        r.getPreco(),
        r.getPrazo(),
        r.getDescricao(),
        r.getImagemDescr(),
        r.getImagem()
      );
      PedidoRoupa pedidoRoupa = new PedidoRoupa(
        key,
        pedido,
        roupa,
        r.getQuantidade()
      );
      listaPedidoRoupa.add(pedidoRoupa);
    }); 
        
    return listaPedidoRoupa;
  }
}
