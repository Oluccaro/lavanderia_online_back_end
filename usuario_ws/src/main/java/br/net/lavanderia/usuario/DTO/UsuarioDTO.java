package br.net.lavanderia.usuario.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
  private Long id;
  private String nome;
  private String login;
  private String cpf;
  private String perfil;
  private String telefone;
  private String dtNascimento;
  private EnderecoDTO endereco;

  public UsuarioDTO(){
    super();
  }

  public UsuarioDTO(Long id, String nome, String login, String cpf, String perfil, 
  String telefone, String dtNascimento,    EnderecoDTO endereco) {
    super();
    this.id = id;
    this.nome = nome;
    this.login = login;
    this.cpf = cpf;
    this.perfil = perfil;
    this.telefone = telefone;
    this.endereco = endereco;
    this.dtNascimento = dtNascimento;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public EnderecoDTO getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoDTO  endereco) {
    this.endereco = endereco;
  }

  public String getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(String dtNascimento) {
    this.dtNascimento = dtNascimento;
  }


  // private int gerarSenha(){
  //   return (int)(Math.random()*8999) + 1000;
  // }
}
