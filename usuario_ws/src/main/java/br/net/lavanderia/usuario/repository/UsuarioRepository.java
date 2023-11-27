package br.net.lavanderia.usuario.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.usuario.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
  
  public Usuario save(Usuario usuario);
  
}
