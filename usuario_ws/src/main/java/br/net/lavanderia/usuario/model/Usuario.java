package br.net.lavanderia.usuario.model;
import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name="nome")
  private String nome;

  @Column(name="login")
  private String login;

  @Column(name="senha")
  private String senha;

  @Column(name="salt")
  private String salt;

  @Column(name="perfil")
  private String perfil;

  @Column(name="cpf")
  private String cpf;

  @Column(name="telefone")
  private String telefone;
                             
  @Column(name="dt_nascimento")
  private String dtNascimento;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="end_id")
  private Endereco endereco;

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

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
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

  public String getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(String dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public static Integer gerarSenha(){
    return (int)(Math.random()*8999) + 1000;
  }
}
