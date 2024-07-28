package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Autor toEntity() {
		Autor autor = new Autor();
		autor.setNome(this.nome);
		autor.setDescricao(this.descricao);
		autor.setEmail(this.email);
		return autor;
	}
}
