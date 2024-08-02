package br.com.cdc.seeddesafiocdc.domain.repository.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "tb_cupom_desconto")
public class CupomDesconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private BigDecimal percentualDesconto;

	private LocalDate dataValidade;
	
	@Deprecated
	public CupomDesconto() {}

	public CupomDesconto(String codigo, BigDecimal percentualDesconto, LocalDate dataValidade) {
		super();
		this.codigo = codigo;
		this.percentualDesconto = percentualDesconto;
		this.dataValidade = dataValidade;
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}
}
