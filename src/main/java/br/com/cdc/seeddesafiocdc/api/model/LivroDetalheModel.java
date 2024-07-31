package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;

public class LivroDetalheModel {

	private Long id;
	private String titulo;
	private String isbn;
	private String sumario;
	private String resumo;
	private String nomeAutor;

	public LivroDetalheModel(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.sumario = livro.getSumario();
		this.resumo = livro.getResumo();
		this.nomeAutor = livro.getAutor().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getResumo() {
		return resumo;
	}
}
