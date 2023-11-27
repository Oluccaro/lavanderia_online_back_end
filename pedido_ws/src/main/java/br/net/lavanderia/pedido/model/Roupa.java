package br.net.lavanderia.pedido.model;

import jakarta.persistence.*;

@Entity
@Table(name="roupa")
public class Roupa  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="preco")
  private Double preco;

  @Column(name="prazo")
  private Integer prazo;

  @Column(name="descricao")
  private String descricao;

  @Column(name="imagem_descr")
  private String imagemDescr;

  @Column(name="imagem")
  private String imagem;

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
