package br.com.cdc.seeddesafiocdc.api.form;

import java.math.BigDecimal;

import br.com.cdc.seeddesafiocdc.api.validation.ExistEntity;
import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 1 ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class PagamentoCarrinhoItemForm {

	@NotNull
	@Positive
	@ExistEntity(fieldName = "id", classReference = Livro.class)
	private Long idLivro;

	@NotNull
	@Positive
	private Integer quantidade;

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal calcularValor(LivroRepository livroRepository) {
		Livro livro = livroRepository.findById(this.idLivro)
				.orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
		BigDecimal quantiade = BigDecimal.valueOf(this.quantidade);
		return livro.getPreco().multiply(quantiade);
	}
}
