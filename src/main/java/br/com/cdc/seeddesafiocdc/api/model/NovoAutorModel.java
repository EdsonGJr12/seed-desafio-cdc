package br.com.cdc.seeddesafiocdc.api.model;

import java.time.LocalDateTime;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;

/**
 * 1 Ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class NovoAutorModel {

	private Long id;
	private LocalDateTime dataCadastro;
	private String nome;
	private String email;
	private String descricao;

	public NovoAutorModel(Autor novoAutor) {
		this.id = novoAutor.getId();
		this.dataCadastro = novoAutor.getDataCadastro();
		this.nome = novoAutor.getNome();
		this.email = novoAutor.getEmail();
		this.descricao = novoAutor.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
}
