package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.api.validation.UniqueValue;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pais;
import jakarta.validation.constraints.NotBlank;

public class NovoPaisForm {

	@NotBlank
	@UniqueValue(fieldName = "nome", classReference = Pais.class)
	private String nome;
	
	public Pais toEntity() {
		return new Pais(this.nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
