package br.net.lavanderia.pedido.rest;
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

import br.net.lavanderia.pedido.DTO.RoupaDTO;
import br.net.lavanderia.pedido.DTO.RoupaDTO;
import br.net.lavanderia.pedido.model.Pedido;
import br.net.lavanderia.pedido.model.Roupa;
import br.net.lavanderia.pedido.repository.PedidoRepository;
import br.net.lavanderia.pedido.repository.RoupaRepository;

@CrossOrigin
@RestController
public class PedidoREST {

  @Autowired
  private PedidoRepository repo;
  
  @Autowired
  private ModelMapper mapper;


  @GetMapping("/pedido")
  public List<Pedido> listarTodos(){
    return repo.findAll();
  }

  // @PostMapping("/roupa")
  // @ResponseStatus(HttpStatus.CREATED)
  // public RoupaDTO insere(@RequestBody RoupaDTO roupa){
  //   repo.save(mapper.map(roupa, Roupa.class));

  //   Roupa rou = repo.findAll().stream()
  //                   .filter(r -> r.getDescricao().equals(roupa.getDescricao()))
  //                   .findAny()
  //                   .orElse(null);
    
  //   return mapper.map(rou, RoupaDTO.class);
  // }

  // @PutMapping("/roupa/{id}")
  // public RoupaDTO altera(@PathVariable Long id,
  //                                         @RequestBody RoupaDTO roupa){
  //   Roupa rou = repo.findById(id).orElse(null);
  //   if(rou != null){
  //     rou.setDescricao(roupa.getDescricao());
  //     rou.setPrazo(roupa.getPrazo());
  //     rou.setPreco(roupa.getPreco());
  //     rou.setImagem(roupa.getImagem());
  //     rou.setImagemDescr(roupa.getImagemDescr());
  //   }
  //   repo.save(rou);
  //   return mapper.map(rou, RoupaDTO.class);
  // }

  // @DeleteMapping("/roupa/{id}")
  // @ResponseStatus(HttpStatus.NO_CONTENT)
  // public void deleta(@PathVariable Long id){
  //   repo.deleteById(id);
  // }
}
