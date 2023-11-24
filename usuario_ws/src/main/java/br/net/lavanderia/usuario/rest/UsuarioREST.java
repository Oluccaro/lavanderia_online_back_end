package br.net.lavanderia.usuario.rest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.endereco.model.Endereco;
import br.net.lavanderia.usuario.model.Usuario;
import br.net.lavanderia.login.model.Login;

@CrossOrigin
@RestController
public class UsuarioREST {
  public static List<Usuario> lista = new ArrayList<Usuario>();

  @GetMapping("/usuarios")
  public List<Usuario> obterTodosUsuarios(){
    return lista;
  }

  @GetMapping("/usuarios/{id}")
  public Usuario getUsuarioById(@PathVariable("id") int id){
    return lista.stream().filter(usu -> usu.getId() == id).findAny().orElse(null);
  }

  @PostMapping("/login")
  public Usuario login(@RequestBody Login login){
    Usuario usuario = lista.stream().filter(usu -> 
      usu.getLogin() == login.getLogin() &&
      usu.getSenha() == login.getSenha()
    )
    .findAny()
    .orElse(null);

    return usuario;
  }

  static{
    Endereco endereco1 = new Endereco("12345-678", "Rua A", "Apto 101", "Centro", "Cidade1", "SP", "123");
    Endereco endereco2 = new Endereco("54321-876", "Rua B", "Casa 2", "Bairro2", "Cidade2", "RJ", "456");
    Endereco endereco3 = new Endereco("98765-432", "Rua C", "Sala 3", "Bairro3", "Cidade3", "MG", "789");
    Endereco endereco4 = new Endereco("11111-111", "Rua D", "Apto 202", "Bairro4", "Cidade4", "BA", "101");
    Endereco endereco5 = new Endereco("22222-222", "Rua E", "Casa 5", "Bairro5", "Cidade5", "RS", "202");
    Usuario usuario1 = new Usuario(1, "Usuario1", "user1", "111.111.111-11", "FUNC", "123456789", endereco1);
    Usuario usuario2 = new Usuario(2, "Usuario2", "user2", "222.222.222-22", "CLIENTE", "987654321", endereco2);
    Usuario usuario3 = new Usuario(3, "Usuario3", "user3", "333.333.333-33", "FUNC", "456789123", endereco3);
    Usuario usuario4 = new Usuario(4, "Usuario4", "user4", "444.444.444-44", "CLIENTE", "321654987", endereco4);
    Usuario usuario5 = new Usuario(5, "Usuario5", "user5", "555.555.555-55", "FUNC", "789123456", endereco5);
    Usuario usuario6 = new Usuario(6, "Usuario6", "user6", "666.666.666-66", "CLIENTE", "654321987", endereco1);
    Usuario usuario7 = new Usuario(7, "Usuario7", "user7", "777.777.777-77", "FUNC", "987654321", endereco2);
    Usuario usuario8 = new Usuario(8, "Usuario8", "user8", "888.888.888-88", "CLIENTE", "321654987", endereco3);
    Usuario usuario9 = new Usuario(9, "Usuario9", "user9", "999.999.999-99", "FUNC", "789123456", endereco4);
    Usuario usuario10 = new Usuario(10, "Usuario10", "user10", "000.000.000-00", "CLIENTE", "654321987", endereco5);
    
    lista.add(usuario1);
    lista.add(usuario2);
    lista.add(usuario3);
    lista.add(usuario4);
    lista.add(usuario5);
    lista.add(usuario6);
    lista.add(usuario7);
    lista.add(usuario8);
    lista.add(usuario9);
    lista.add(usuario10);
  }
}
