package br.net.lavanderia.pedido.DTO;

import java.io.Serializable;
import java.util.Date;

public class ReceitasDTO implements Serializable{
  private String dataReferencia;
  private Double receita;

  
  public ReceitasDTO() {
    super();
  }

  public ReceitasDTO(String dataReferencia, Double receita) {
    super();
    this.dataReferencia = dataReferencia;
    this.receita = receita;
  }
  public String getDataReferencia() {
    return dataReferencia;
  }
  public void setDataReferencia(String dataReferencia) {
    this.dataReferencia = dataReferencia;
  }
  public Double getReceita() {
    return receita;
  }
  public void setReceita(Double receita) {
    this.receita = receita;
  }

  public void addReceita(Double receita){
    this.receita += receita;
  }
}
