package br.com.cdc.seeddesafiocdc.api.form;

import java.math.BigDecimal;
import java.util.List;

import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pedido;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.PedidoLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 4 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class PagamentoCarrinhoForm {
	
	@NotNull
	@Positive
	private BigDecimal total;
	
	@NotNull
	@NotEmpty
	@Valid
	private List<PagamentoCarrinhoItemForm> itens;

	public void validarValorTotal(LivroRepository livroRepository) {
		BigDecimal totalCalculado = calcularTotal(livroRepository);
		if (this.total.compareTo(totalCalculado) != 0) {
			throw new IllegalArgumentException("Valor calculado difere do valor total");
		}
	}
	
	public Pedido toEntity(LivroRepository livroRepository) {
		List<PedidoLivro> itens = this.itens.stream()
			.map(item -> {
				Livro livro = livroRepository.getReferenceById(item.getIdLivro());
				return new PedidoLivro(livro, item.getQuantidade());
			}).toList();
		
		return new Pedido(itens, total);
	}
	
	private BigDecimal calcularTotal(LivroRepository livroRepository) {
		return this.itens.stream()
				.map(item -> item.calcularValor(livroRepository))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public void setItens(List<PagamentoCarrinhoItemForm> itens) {
		this.itens = itens;
	}
}
