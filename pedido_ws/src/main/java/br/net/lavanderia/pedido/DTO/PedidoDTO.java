package br.net.lavanderia.pedido.DTO;

import java.io.Serializable;


public class PedidoDTO implements Serializable {
  private Long id;
  private String status;
  private Double valor;
  private String dataPedido;
  private String dtEntregaPrevista;
  private Long idCliente; 

  public PedidoDTO() {
    super();
  }

  public PedidoDTO(Long id, String status, Double valor, String dataPedido, String dtEntregaPrevista, Long idCliente
  ) {
    super();
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
