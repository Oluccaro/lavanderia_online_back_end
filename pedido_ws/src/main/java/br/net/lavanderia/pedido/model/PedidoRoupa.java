package br.net.lavanderia.pedido.model;

import java.util.Objects;

import br.net.lavanderia.pedido.model.key.PedidoRoupaKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_roupa")
public class PedidoRoupa {
  @EmbeddedId
  private PedidoRoupaKey id;

  @ManyToOne
  @MapsId("idPedido")
  @JoinColumn(name = "id_pedido")
  private Pedido pedido;

  @ManyToOne
  @MapsId("idRoupa")
  @JoinColumn(name = "id_roupa")
  private Roupa roupa;

  @Column(name = "quantidade")
  private Integer quantidade;

  public PedidoRoupa() {
  }

  public PedidoRoupa(PedidoRoupaKey id, Pedido pedido, Roupa roupa, Integer quantidade) {
    this.id = id;
    this.pedido = pedido;
    this.roupa = roupa;
    this.quantidade = quantidade;
  }

  public PedidoRoupaKey getId() {
    return id;
  }

  public void setId(PedidoRoupaKey id) {
    this.id = id;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Roupa getRoupa() {
    return roupa;
  }

  public void setRoupa(Roupa roupa) {
    this.roupa = roupa;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
  
}