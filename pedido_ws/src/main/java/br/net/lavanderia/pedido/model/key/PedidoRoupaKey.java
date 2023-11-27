package br.net.lavanderia.pedido.model.key;

import java.io.Serializable;

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
}