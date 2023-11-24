package br.net.lavanderia.endereco.model;

public class Endereco {
  private String cep;
  private String logradouro;
  private String complement;
  private String bairro;
  private String localidade;
  private String uf;
  private String numero;

  public Endereco(String cep, String logradouro, String complement, String bairro, String localidade, String uf, String numero) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.complement = complement;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf.toUpperCase();
    this.numero = numero;
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


  public String getComplement() {
    return complement;
  }


  public void setComplement(String complement) {
    this.complement = complement;
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


  public String getNumero() {
    return numero;
  }


  public void setNumero(String numero) {
    this.numero = numero;
  }
  
}
