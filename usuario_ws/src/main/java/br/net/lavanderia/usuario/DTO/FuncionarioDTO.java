package br.net.lavanderia.usuario.DTO;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {
  private Long id;
  private String nome;
  private String login;
  private String perfil;
  private String dtNascimento;
  
  public FuncionarioDTO() {
    super();
  }
  public FuncionarioDTO(Long id, String nome, String login, String perfil, String dtNascimento) {
    super();
    this.id = id;
    this.nome = nome;
    this.login = login;
    this.perfil = perfil;
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
  public String getPerfil() {
    return perfil;
  }
  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }
  public String getDtNascimento() {
    return dtNascimento;
  }
  public void setDtNascimento(String dtNascimento) {
    this.dtNascimento = dtNascimento;
  }
}
