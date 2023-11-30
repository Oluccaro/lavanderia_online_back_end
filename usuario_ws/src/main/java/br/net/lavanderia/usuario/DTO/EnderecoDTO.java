package br.net.lavanderia.usuario.DTO;

public class EnderecoDTO {
  private Long id;

  private String cep;

  private String logradouro;

  private String bairro;

  private String localidade;

  private String uf;

  private Integer ibge;

  private Integer gia;

  private Integer ddd;

  private Integer siaf;

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

  public void setIbge(Integer ibge) {
    this.ibge = ibge;
  }

  public Integer getGia() {
    return gia;
  }

  public void setGia(Integer gia) {
    this.gia = gia;
  }

  public Integer getDdd() {
    return ddd;
  }

  public void setDdd(Integer ddd) {
    this.ddd = ddd;
  }

  public Integer getSiaf() {
    return siaf;
  }

  public void setSiaf(Integer siaf) {
    this.siaf = siaf;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }
}