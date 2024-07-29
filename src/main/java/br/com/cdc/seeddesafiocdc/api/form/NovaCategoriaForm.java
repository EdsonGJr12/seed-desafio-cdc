package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.api.validation.UniqueValue;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;
import jakarta.validation.constraints.NotBlank;

public class NovaCategoriaForm {

	@NotBlank
	@UniqueValue(fieldName = "nome", classReference = Categoria.class)
	private String nome;

	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
