package br.net.lavanderia.pedido.model.key;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoRoupaKey implements Serializable{
  @Column(name = "id_pedido")
  Long idPedido;

  @Column(name = "id_roupa")
  Long idRoupa;

  public PedidoRoupaKey() {
    super();
  }

  public PedidoRoupaKey(Long idPedido, Long idRoupa) {
    super();
    this.idPedido = idPedido;
    this.idRoupa = idRoupa;
  }

  public Long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Long idPedido) {
    this.idPedido = idPedido;
  }

  public Long getIdRoupa() {
    return idRoupa;
  }

  public void setIdRoupa(Long idRoupa) {
    this.idRoupa = idRoupa;
  }
  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public boolean equals(Object obj) {
    PedidoRoupaKey pedidoRoupaKey = (PedidoRoupaKey) obj;
    if(pedidoRoupaKey.getIdPedido() == this.getIdPedido() &&
      pedidoRoupaKey.getIdRoupa() == this.getIdRoupa()){
        return true;
    }
    else {
      return false;
    }
  }
}