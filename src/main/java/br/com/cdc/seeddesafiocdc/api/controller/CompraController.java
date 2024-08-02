package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cdc.seeddesafiocdc.api.form.RealizarCompraForm;
import br.com.cdc.seeddesafiocdc.api.model.CompraDetalhesModel;
import br.com.cdc.seeddesafiocdc.api.model.CompraRealizadaModel;
import br.com.cdc.seeddesafiocdc.domain.repository.CompraRepostory;
import br.com.cdc.seeddesafiocdc.domain.repository.CupomDescontoRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.EstadoRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.PaisRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Compra;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/compras")
/**
 * 4 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class CompraController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CompraRepostory compraRepostory;
	
	@Autowired
	private CupomDescontoRepository cupomDescontoRepository;
	
	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public CompraRealizadaModel realizarCompra(@RequestBody @Valid RealizarCompraForm pagamentoForm) {
		Compra compra = pagamentoForm.toEntity(paisRepository, livroRepository, estadoRepository, cupomDescontoRepository);
		compraRepostory.save(compra);
		return new CompraRealizadaModel(compra);
	}
	
	@GetMapping("/{id}")
	public CompraDetalhesModel buscarDetalhes(@PathVariable Long id) {
		Compra compra = compraRepostory.findById(id)
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		return new CompraDetalhesModel(compra);
	}
}
