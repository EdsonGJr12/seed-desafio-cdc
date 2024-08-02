package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 1 ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
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
		return new Autor(nome, email, descricao);
	}
}
