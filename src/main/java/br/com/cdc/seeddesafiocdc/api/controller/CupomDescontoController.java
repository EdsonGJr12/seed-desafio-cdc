package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdc.seeddesafiocdc.api.form.NovoCupomDescontoForm;
import br.com.cdc.seeddesafiocdc.api.model.NovoCupomDescontoModel;
import br.com.cdc.seeddesafiocdc.domain.repository.CupomDescontoRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.CupomDesconto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cupons-desconto")
/**
 * 3 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class CupomDescontoController {
	
	@Autowired
	private CupomDescontoRepository cupomDescontoRepository;

	@PostMapping
	public NovoCupomDescontoModel cadastrarCupomDesconto(@RequestBody @Valid NovoCupomDescontoForm novoCupomDescontoForm) {
		CupomDesconto novoCupom = novoCupomDescontoForm.toEntity();
		cupomDescontoRepository.save(novoCupom);
		return new NovoCupomDescontoModel(novoCupom);
	}
}
