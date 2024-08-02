package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pais;

public class PaisModel {
	
	private Long id;
	private String nome;

	public PaisModel(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

}
