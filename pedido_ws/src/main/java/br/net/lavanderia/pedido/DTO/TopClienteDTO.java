package br.net.lavanderia.pedido.DTO;

import java.io.Serializable;

public class TopClienteDTO implements Serializable{
  private Long idCliente;

  private Integer quantidadePedidos;
  private Double receitaTotal;
  
  public TopClienteDTO() {
    super();
    this.quantidadePedidos = 0;
    this.receitaTotal = 0.0;
  }
  
  public TopClienteDTO(Long idCliente, Integer quantidadePedidos, Double receitaTotal) {
    super();
    this.idCliente = idCliente;
    this.quantidadePedidos = quantidadePedidos;
    this.receitaTotal = receitaTotal;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }
  
  public Integer getQuantidadePedidos() {
    return quantidadePedidos;
  }
  public void setQuantidadePedidos(Integer quantidadePedidos) {
    this.quantidadePedidos = quantidadePedidos;
  }
  public Double getReceitaTotal() {
    return receitaTotal;
  }
  public void setReceitaTotal(Double receitaTotal) {
    this.receitaTotal = receitaTotal;
  }

  public void addQuantidadePedidos(){
    this.quantidadePedidos++;
  }

  public void addReceitaTotal(Double receita){
    this.receitaTotal += receita;
  }
}
