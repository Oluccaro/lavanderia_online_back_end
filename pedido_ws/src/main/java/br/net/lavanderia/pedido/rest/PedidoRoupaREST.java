package br.net.lavanderia.pedido.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.pedido.DTO.PedidoRoupaDTO;
import br.net.lavanderia.pedido.mapper.PedidoRoupaMapper;
import br.net.lavanderia.pedido.model.Pedido;
import br.net.lavanderia.pedido.model.PedidoRoupa;
import br.net.lavanderia.pedido.repository.PedidoRepository;
import br.net.lavanderia.pedido.repository.PedidoRoupaRepository;

@CrossOrigin
@RestController
public class PedidoRoupaREST {

  @Autowired
  private PedidoRoupaRepository repo;

  @Autowired
  private PedidoRepository repoPedido;

  @GetMapping("/pedido")
  public List<PedidoRoupaDTO> listarTodos(){
    return listaPedidoRoupaDTOs();
  }

  @GetMapping("/pedido/cliente/{id}")
  public List<PedidoRoupaDTO> buscarPorIdCliente(@PathVariable Long id){
    return listaPedidoRoupaDTOs().stream().filter(i -> i.getIdCliente() == id).collect(Collectors.toList());
  }

  @GetMapping("/pedido/{id}")
  public PedidoRoupaDTO buscarPorId(@PathVariable Long id){
    return listaPedidoRoupaDTOs().stream().filter(i -> i.getId() == id).findFirst().orElse(null);
  }

  @GetMapping("/pedido/status/{status}")
  public List<PedidoRoupaDTO> buscarPorStatus(@PathVariable String status){
    return listaPedidoRoupaDTOs().stream().filter(i -> i.getStatus().equals(status)).collect(Collectors.toList());
  }

  @PostMapping("/pedido")
  @ResponseStatus(HttpStatus.CREATED)
  public PedidoRoupaDTO insere(@RequestBody PedidoRoupaDTO pedidoRoupaDTO){
    List<PedidoRoupa> pedidoRoupa = PedidoRoupaMapper.toPedidoRoupa(pedidoRoupaDTO);
    Pedido pedido = pedidoRoupa.get(0).getPedido();
    repoPedido.save(pedido);
  
    List<PedidoRoupaDTO> lista = new ArrayList<PedidoRoupaDTO>();
    pedidoRoupa.stream().forEach(p ->{
      repo.save(p);
      PedidoRoupaMapper.toListPedidoRoupaDTO(p, lista);
    });
    return lista.get(0);
  }

  @PutMapping("/pedido/{id}")
  public PedidoRoupaDTO altera(@PathVariable Long id,
  @RequestBody PedidoRoupaDTO pedidoRoupaDTO){
    Pedido pedidoAtualizado = PedidoRoupaMapper.toPedidoRoupa(pedidoRoupaDTO).get(0).getPedido();
    PedidoRoupa pedidoRoupa = repo.findAll().stream().filter(p -> p.getPedido().getId() == id).findAny().orElse(null);
    if(pedidoRoupa != null){
      Pedido pedidoAntigo = pedidoRoupa.getPedido();
      pedidoAntigo.setStatus(pedidoAtualizado.getStatus());
      pedidoAntigo.setDataPedido(pedidoAtualizado.getDataPedido());
      pedidoAntigo.setDtEntregaPrevista(pedidoAtualizado.getDtEntregaPrevista());
      pedidoAntigo.setValor(pedidoAtualizado.getValor());
      pedidoAntigo.setIdCliente(pedidoAtualizado.getIdCliente());
      repoPedido.save(pedidoAntigo);
    }
    List<PedidoRoupaDTO> lista = new ArrayList<PedidoRoupaDTO>();
    repo.findAll().stream()
                  .filter(
                    p -> p.getPedido().getId() == id)
                  .forEach(
                    p -> PedidoRoupaMapper.toListPedidoRoupaDTO(p, lista));
    
    return lista.get(0);
  }
  
  private List<PedidoRoupaDTO> listaPedidoRoupaDTOs(){
    List<PedidoRoupaDTO> lista = new ArrayList<PedidoRoupaDTO>();
    repo.findAll().stream().forEach(
      p -> PedidoRoupaMapper.toListPedidoRoupaDTO(p, lista)
    );
    return lista;
  }
}
