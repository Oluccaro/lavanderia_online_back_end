package br.net.lavanderia.pedido.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.pedido.model.Roupa;

@Repository
public interface RoupaRepository  extends JpaRepository<Roupa, Long>{
  public Roupa save(Roupa roupa);  
}
