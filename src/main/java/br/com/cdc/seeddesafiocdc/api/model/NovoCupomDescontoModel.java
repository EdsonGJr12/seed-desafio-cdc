package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.repository.entity.CupomDesconto;

/**
 * 1 Ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class NovoCupomDescontoModel {

	private Long id;
	private String codigo;

	public NovoCupomDescontoModel(CupomDesconto cupom) {
		this.id = cupom.getId();
		this.codigo = cupom.getCodigo();
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}
}
