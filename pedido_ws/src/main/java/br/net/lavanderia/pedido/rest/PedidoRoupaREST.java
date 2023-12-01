package br.net.lavanderia.pedido.rest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.pedido.DTO.PedidoRoupaDTO;
import br.net.lavanderia.pedido.DTO.ReceitasDTO;
import br.net.lavanderia.pedido.DTO.RoupaQtdDTO;
import br.net.lavanderia.pedido.DTO.TopClienteDTO;
import br.net.lavanderia.pedido.comparator.DataComparer;
import br.net.lavanderia.pedido.comparator.PedidoRoupaDTOComparer;
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
    pedido.setValor(getReceitaRoupas(lista.get(0).getRoupas()));
    repoPedido.save(pedido);
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
    
    return lista.stream().filter(i -> i.getId() == id).findAny().orElse(null);
  }

  @GetMapping("relatorio/top3cliente")
  public List<TopClienteDTO> listarTopTres(){
    List<PedidoRoupaDTO> listaPedidos = listaPedidoRoupaDTOs();
    Collections.sort(listaPedidos, new PedidoRoupaDTOComparer());
    //Collections.sort(listaPedidos, Comparator.comparingLong(PedidoRoupaDTO::getIdCliente));
    listaPedidos.forEach(p -> System.out.println(p.getIdCliente()));
    List<TopClienteDTO> topClientes = new ArrayList<TopClienteDTO>();
    PedidoRoupaDTO primeiroPedido = listaPedidos.get(0);
    TopClienteDTO topClienteAnterior = new TopClienteDTO(
      primeiroPedido.getIdCliente(),
      0,
      getReceitaRoupas(primeiroPedido.getRoupas())
      );
    for(PedidoRoupaDTO p : listaPedidos){      
      if(p.getIdCliente() != topClienteAnterior.getIdCliente()){
        topClientes.add(topClienteAnterior);
        if(topClientes.size() == 3) break;
        topClienteAnterior = new TopClienteDTO(
          p.getIdCliente(),
          1,
          getReceitaRoupas(p.getRoupas())
        );
      } else {
        topClienteAnterior.addQuantidadePedidos();
        topClienteAnterior.addReceitaTotal(getReceitaRoupas(p.getRoupas()));
      }
    }
    return topClientes;
  }  

  @GetMapping("/relatorios/receita")
  public List<ReceitasDTO> listarReceitas(@RequestParam("dt_inicial") Optional<String> dtInicial,
                                          @RequestParam("dt_final") Optional<String> dtFinal){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
    List<ReceitasDTO> listaReceitas = new ArrayList<ReceitasDTO>();
    List<PedidoRoupaDTO> pedidoRoupas = listaPedidoRoupaDTOs();
    if(dtInicial.isPresent()){
      pedidoRoupas.stream()
      .filter(p -> {
        try {
          return formatter.parse(p.getDataPedido()).after(formatter.parse(dtInicial.get()));
        } catch (ParseException e) {
          e.printStackTrace();
          return false;
        }
      })
      .collect(Collectors.toList());
    }
    if(dtFinal.isPresent()){
      pedidoRoupas.stream()
      .filter(p -> {
        try {
          return formatter.parse(p.getDataPedido()).before(formatter.parse(dtFinal.get()));
        } catch (ParseException e) {
          e.printStackTrace();
          return false;
        }
      })
      .collect(Collectors.toList());
    }
    Collections.sort(pedidoRoupas, new DataComparer());
    PedidoRoupaDTO primeiroPedido = pedidoRoupas.get(0);
    ReceitasDTO receita = new ReceitasDTO(primeiroPedido.getDataPedido(), primeiroPedido.getValor());
    for(PedidoRoupaDTO pedido : pedidoRoupas){
      if(!receita.getDataReferencia().equals(pedido.getDataPedido())){
        listaReceitas.add(receita);
        receita = new ReceitasDTO(pedido.getDataPedido(), pedido.getValor());
      }
      else {
        receita.addReceita(pedido.getValor());
      }
    }
    return listaReceitas;
  }
  
  private List<PedidoRoupaDTO> listaPedidoRoupaDTOs(){
    List<PedidoRoupaDTO> lista = new ArrayList<PedidoRoupaDTO>();
    repo.findAll().stream().forEach(
      p -> PedidoRoupaMapper.toListPedidoRoupaDTO(p, lista)
    );
    return lista;
  }
  
  private Double getReceitaRoupas(List<RoupaQtdDTO> roupas){
    Double total = 0.0;
    for(RoupaQtdDTO r : roupas){
      total += r.getPreco()*r.getQuantidade();
    }
    return total;
  }
}
