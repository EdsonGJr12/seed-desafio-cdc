package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.api.validation.UniqueValue;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Estado;
import jakarta.validation.constraints.NotBlank;

public class NovoEstadoForm {
	
	@NotBlank
	@UniqueValue(fieldName = "nome", classReference = Estado.class)
	private String nome;
	
	public Estado toEntity() {
		return new Estado(this.nome);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
