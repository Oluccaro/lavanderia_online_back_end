package br.net.lavanderia.usuario.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.net.lavanderia.usuario.model.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
}
