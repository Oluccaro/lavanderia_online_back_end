package br.net.lavanderia.usuario.rest;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.usuario.DTO.UsuarioDTO;
import br.net.lavanderia.usuario.model.Login;
import br.net.lavanderia.usuario.model.Usuario;
import br.net.lavanderia.usuario.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class AuthREST {

  @Autowired
  private UsuarioRepository repo;
  
  @Autowired
  private ModelMapper mapper;


  public static List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

  @PostMapping("/login")
  public UsuarioDTO login(@RequestBody Login login){
    UsuarioDTO usuario = repo.findAll().stream()
    .filter(usu -> 
      usu.getLogin().equals(login.getLogin()) &&
      usu.getSenha().equals(login.getSenha())
    )
    .map(e -> mapper.map(e, UsuarioDTO.class))
    .findAny()
    .orElse(null);

    return usuario;
  }

  @PostMapping("/cadastro")
  public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuario){
    repo.save(mapper.map(usuario, Usuario.class));
    Usuario usu = repo.findAll().stream()
                  .filter(u -> u.getLogin().equals(usuario.getLogin()))
                  .findAny()
                  .orElse(null);
    return mapper.map(usu, UsuarioDTO.class);
  }
}
