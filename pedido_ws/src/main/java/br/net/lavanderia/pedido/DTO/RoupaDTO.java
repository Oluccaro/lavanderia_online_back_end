package br.net.lavanderia.pedido.DTO;

import java.io.Serializable;

public class RoupaDTO implements Serializable {
  private Long id;
  private Double preco;
  private Integer prazo;
  private String descricao;
  private String imagemDescr;
  private String imagem;
  
  public RoupaDTO() {
    super();
  }

  public RoupaDTO(Long id, Double preco, Integer prazo, String descricao, String imagemDescr, String imagem) {
    super();
    this.id = id;
    this.preco = preco;
    this.prazo = prazo;
    this.descricao = descricao;
    this.imagemDescr = imagemDescr;
    this.imagem = imagem;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Integer getPrazo() {
    return prazo;
  }

  public void setPrazo(Integer prazo) {
    this.prazo = prazo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getImagemDescr() {
    return imagemDescr;
  }

  public void setImagemDescr(String imagemDescr) {
    this.imagemDescr = imagemDescr;
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  
}
