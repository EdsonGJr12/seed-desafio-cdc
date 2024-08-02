package br.com.cdc.seeddesafiocdc.api.model;

import java.math.BigDecimal;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.Compra;

public class CompraDetalhesModel {
	private BigDecimal valorCompra;
	private boolean existeCupom;
	private BigDecimal valorCompraComCupom;

	public CompraDetalhesModel(Compra compra) {
		this.existeCupom = compra.isCupomAplicado();
		if (this.existeCupom) {
			this.valorCompraComCupom = compra.getValorCompra();
		} else {
			this.valorCompra = compra.getValorCompra();
		}
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public boolean isExisteCupom() {
		return existeCupom;
	}

	public BigDecimal getValorCompraComCupom() {
		return valorCompraComCupom;
	}

}
