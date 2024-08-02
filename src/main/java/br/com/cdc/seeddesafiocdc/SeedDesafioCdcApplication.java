package br.com.cdc.seeddesafiocdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Métricas
 * 1 ponto - cada acoplamento com classes específicas do projeto(não está sendo considerado interfaces Repositories nesse projeto)
 * 1 ponto - cada branh de código encontrada(if, else, ? ternário, :ternário, loop, switch case, try, catch)
 * 1 ponto - cada função como argumento(não está sendo considerado nesse projeto)
 * 
 * Classes que possuem atributos de dependência - limite de 7 pontos
 * Classes que possuem atributos de estado - limite de 9 pontos
 */
@SpringBootApplication
public class SeedDesafioCdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeedDesafioCdcApplication.class, args);
	}

}
