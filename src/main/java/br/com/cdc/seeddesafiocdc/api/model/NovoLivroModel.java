package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;

public class NovoLivroModel {

	private Long id;
	private String titulo;

	public NovoLivroModel(Livro novoLivro) {
		this.id = novoLivro.getId();
		this.titulo = novoLivro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
