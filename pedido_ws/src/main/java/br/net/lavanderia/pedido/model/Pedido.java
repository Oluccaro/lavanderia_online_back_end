package br.net.lavanderia.pedido.model;

import jakarta.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="status")
  private String status;

  @Column(name="valor")
  private Double valor;

  @Column(name="dt_pedido")
  private String dataPedido;

  @Column(name="dt_entrega_prevista")
  private String dtEntregaPrevista;

  @Column(name="id_cliente")
  private Long idCliente; 

  // @OneToMany
  // @JoinTable(name = "pedido_roupa",
  //   joinColumns = @JoinColumn(name = "id_pedido"),
  //   inverseJoinColumns = @JoinColumn(name ="id_roupa")
  // )
  // private List<Roupa> roupas;

  // public List<Roupa> getRoupas() {
  //   return roupas;
  // }

  // public void setRoupas(List<Roupa> roupas) {
  //   this.roupas = roupas;
  // }

  public Pedido() {
  }

  public Pedido(Long id, String status, Double valor, String dataPedido, String dtEntregaPrevista, Long idCliente
  ) {
    this.id = id;
    this.status = status;
    this.valor = valor;
    this.dataPedido = dataPedido;
    this.dtEntregaPrevista = dtEntregaPrevista;
    this.idCliente = idCliente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(String dataPedido) {
    this.dataPedido = dataPedido;
  }

  public String getDtEntregaPrevista() {
    return dtEntregaPrevista;
  }

  public void setDtEntregaPrevista(String dtEntregaPrevista) {
    this.dtEntregaPrevista = dtEntregaPrevista;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }
}
