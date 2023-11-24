package br.net.lavanderia.usuario.model;

import java.io.Serializable;
import br.net.lavanderia.endereco.model.*;

public class Usuario implements Serializable {
  private int id;
  private String nome;
  private String login;
  private int senha;
  private String cpf;
  private String perfil;
  private String telefone;
  private Endereco endereco;

  public Usuario(){
    super();
  }

  public Usuario(int id, String nome, String login, String cpf, String perfil, String telefone,
      Endereco endereco) {
    super();
    this.id = id;
    this.nome = nome;
    this.login = login;
    this.senha = this.gerarSenha();
    this.cpf = cpf;
    this.perfil = perfil;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public int getSenha() {
    return senha;
  }

  public void setSenha(int senha) {
    this.senha = senha;
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

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  private int gerarSenha(){
    return (int)(Math.random()*8999) + 1000;
  }
}
