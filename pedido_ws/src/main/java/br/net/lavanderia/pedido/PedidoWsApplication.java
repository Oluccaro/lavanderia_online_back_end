package br.net.lavanderia.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"br.net.lavanderia"})
@SpringBootApplication
public class PedidoWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoWsApplication.class, args);
	}

}
