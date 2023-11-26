package br.net.lavanderia.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableJpaRepositories("br.net.lavanderia.usuario.repository")
@ComponentScan(basePackages = {"br.net.lavanderia"})
@SpringBootApplication
public class UsuarioWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioWsApplication.class, args);
	}	

}
