package br.net.lavanderia.usuario.model;

import jakarta.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="cep")
  private String cep;

  @Column(name="logradouro")
  private String logradouro;

  @Column(name="complemento")
  private String complemento;

  @Column(name="bairro")
  private String bairro;

  @Column(name="localidade")
  private String localidade;

  @Column(name="uf")
  private String uf;

  @Column(name="ibge")
  private Integer ibge;

  @Column(name="gia")
  private Integer gia;

  @Column(name="ddd")
  private Integer ddd;

  @Column(name="siaf")
  private Integer siaf;

  @Column(name="numero")
  private String numero;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public Integer getIbge() {
    return ibge;
  }

  public void setIbge(int ibge) {
    this.ibge = ibge;
  }

  public Integer getGia() {
    return gia;
  }

  public void setGia(int gia) {
    this.gia = gia;
  }

  public Integer getDdd() {
    return ddd;
  }

  public void setDdd(int ddd) {
    this.ddd = ddd;
  }

  public Integer getSiaf() {
    return siaf;
  }

  public void setSiaf(int siaf) {
    this.siaf = siaf;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

}
