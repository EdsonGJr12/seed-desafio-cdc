package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
/**
 * 1 Ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class LivroModel {

	private Long id;
	private String titulo;

	public LivroModel(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
