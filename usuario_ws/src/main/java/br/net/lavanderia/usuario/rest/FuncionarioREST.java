package br.net.lavanderia.usuario.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.login.model.Login;
import br.net.lavanderia.usuario.DTO.FuncionarioDTO;
import br.net.lavanderia.usuario.DTO.UsuarioDTO;
import br.net.lavanderia.usuario.model.Usuario;
import br.net.lavanderia.usuario.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class FuncionarioREST {

  @Autowired
  private UsuarioRepository repo;
  
  @Autowired
  private ModelMapper mapper;


  public static List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

  @GetMapping("/funcionario")
  @ResponseStatus(HttpStatus.CREATED)
  public List<FuncionarioDTO> listarTodos(){
    return repo.findAll().stream()
               .filter(f -> f.getPerfil().equals("FUNC"))
               .map(e -> mapper.map(e, FuncionarioDTO.class))
               .collect(Collectors.toList());
  }

  @PostMapping("/funcionario")
  public FuncionarioDTO insereFuncionario(@RequestBody FuncionarioDTO funcionario){
    repo.save(mapper.map(funcionario, Usuario.class));

    Usuario usuario = repo.findAll().stream()
                       .filter(u -> u.getLogin().equals(funcionario.getLogin()))
                       .findAny().orElse(null);
    
    return mapper.map(usuario, FuncionarioDTO.class);
  }

  @PutMapping("/funcionario/{id}")
  public FuncionarioDTO alteraFuncionario(@PathVariable Long id,
                                          @RequestBody FuncionarioDTO funcionario){
    Usuario usuario = repo.findById(id).orElse(null);
    if(usuario != null){
      usuario.setNome(funcionario.getNome());
      usuario.setLogin(funcionario.getLogin());
      usuario.setDtNascimento(funcionario.getDtNascimento());
    }
    repo.save(usuario);
    return mapper.map(usuario, FuncionarioDTO.class);
  }

  @DeleteMapping("/funcionario/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleta(@PathVariable Long id){
    repo.deleteById(id);
  }
}
