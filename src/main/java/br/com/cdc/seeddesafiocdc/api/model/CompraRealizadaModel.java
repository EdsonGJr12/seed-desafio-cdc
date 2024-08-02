package br.com.cdc.seeddesafiocdc.api.model;

import br.com.cdc.seeddesafiocdc.domain.constants.StatusCompra;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Compra;

public class CompraRealizadaModel {
	private Long id;
	private StatusCompra status;

	public CompraRealizadaModel(Compra compra) {
		this.id = compra.getId();
		this.status = compra.getStatus();
	}

	public Long getId() {
		return id;
	}

	public StatusCompra getStatus() {
		return status;
	}
}
