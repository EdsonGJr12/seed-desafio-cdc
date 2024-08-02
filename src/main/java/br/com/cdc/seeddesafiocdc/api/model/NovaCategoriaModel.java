package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;

/**
 * 1 Ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class NovaCategoriaModel {

	private Long id;
	private String nome;

	public NovaCategoriaModel(Categoria novaCategoria) {
		this.id = novaCategoria.getId();
		this.nome = novaCategoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
