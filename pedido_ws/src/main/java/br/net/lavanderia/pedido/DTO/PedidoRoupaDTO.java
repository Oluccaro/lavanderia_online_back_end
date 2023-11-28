package br.net.lavanderia.pedido.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PedidoRoupaDTO implements Serializable{
  private Long id;
  private String status;
  private Double valor;
  private String dataPedido;
  private String dtEntregaPrevista;
  private Long idCliente; 
  private List<RoupaQtdDTO> roupas;
  
  
  public PedidoRoupaDTO() {
    super();
    this.roupas = new ArrayList<RoupaQtdDTO>();
  }
  public PedidoRoupaDTO(Long id, String status, Double valor, String dataPedido, String dtEntregaPrevista,
      Long idCliente) {
    super();
    this.id = id;
    this.status = status;
    this.valor = valor;
    this.dataPedido = dataPedido;
    this.dtEntregaPrevista = dtEntregaPrevista;
    this.idCliente = idCliente;
    this.roupas = new ArrayList<RoupaQtdDTO>();
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
  public List<RoupaQtdDTO> getRoupas() {
    return this.roupas;
  }
  public void setRoupas(List<RoupaQtdDTO> roupa) {
    this.roupas = roupa;
  }
  public void addRoupas(RoupaQtdDTO roupa){
    this.roupas.add(roupa);
  }

}
