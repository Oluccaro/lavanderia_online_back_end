package br.net.lavanderia.usuario.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.usuario.DTO.UsuarioDTO;
import br.net.lavanderia.usuario.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class ClienteREST {

  @Autowired
  UsuarioRepository repoUsuario;

  @Autowired
  ModelMapper mapper;

  @GetMapping("/relatorio/cliente")
  public List<UsuarioDTO> listarTodos(){
    return repoUsuario
           .findAll()
           .stream()
           .filter(u -> u.getPerfil().equals("CLIENTE"))
           .map(u -> mapper.map(u, UsuarioDTO.class))
           .collect(Collectors.toList());
  }

  @GetMapping("/cliente/{id}")
  public UsuarioDTO buscarPorId(@PathVariable Long id){
    return mapper.map(repoUsuario.findById(id).orElse(null), UsuarioDTO.class);
  }
}
