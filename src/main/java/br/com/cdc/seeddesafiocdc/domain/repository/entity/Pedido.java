package br.com.cdc.seeddesafiocdc.domain.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal total;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_pedido")
	private List<PedidoLivro> itens = new ArrayList<>();

	public Pedido(List<PedidoLivro> itens, BigDecimal total) {
		this.total = total;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<PedidoLivro> getItens() {
		return itens;
	}
}
