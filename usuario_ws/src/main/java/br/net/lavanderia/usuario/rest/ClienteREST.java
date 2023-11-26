// package br.net.lavanderia.usuario.rest;

// import java.util.stream.Collectors;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import br.net.lavanderia.usuario.DTO.UsuarioDTO;
// import br.net.lavanderia.usuario.model.Usuario;

// public class ClienteREST {
//   @GetMapping("/cliente")
//   public List<UsuarioDTO> listarTodos(){
//     List<Usuario> lista = repo.findAll();
//     return lista.stream()
//                 .filter(usu -> usu.getPerfil().equals("CLIENTE"))
//                 .map(e -> mapper.map(e, UsuarioDTO.class))
//                 .collect(Collectors.toList());
//   }

//   @GetMapping("/usuarios/{id}")
//   public UsuarioDTO getUsuarioById(@PathVariable("id") int id){
//     return repo.findAll().stream()
//             .filter(usu -> usu.getId() == id)
//             .map(e -> mapper.map(e, UsuarioDTO.class))
//             .findAny().orElse(null);
//   }
// }
