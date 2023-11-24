package br.net.lavanderia.login.model;

import java.io.Serializable;

public class Login implements Serializable {
  private String login;
  private int senha;

  public Login(String login, int senha) {
    this.login = login;
    this.senha = senha;
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

  public Login() {
    super();
  }
}