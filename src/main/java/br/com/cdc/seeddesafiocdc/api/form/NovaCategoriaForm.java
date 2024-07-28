package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;
import jakarta.validation.constraints.NotBlank;

public class NovaCategoriaForm {
	
	@NotBlank
	private String nome;

	public Categoria toEntity() {
		return new Categoria(this.nome);
	}
}
