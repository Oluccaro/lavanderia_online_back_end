package br.net.lavanderia.usuario.repository;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.usuario.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
  
  public Usuario save(Usuario usuario);
  public Usuario findByLoginAndSenha(@Param("login") String login,
                              @Param("senha") String senha);

  public List<Usuario> findByPerfil(String perfil);
  
}
