package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdc.seeddesafiocdc.api.form.NovoAutorForm;
import br.com.cdc.seeddesafiocdc.api.model.NovoAutorModel;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;
import br.com.cdc.seeddesafiocdc.domain.service.CadastroAutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
/**
 * 4 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class AutorController {
	
	@Autowired
	private CadastroAutorService cadastroAutorService;

	@PostMapping
	public NovoAutorModel cadastrar(@RequestBody @Valid NovoAutorForm novoAutorForm) {
		Autor novoAutor = novoAutorForm.toEntity();
		cadastroAutorService.cadastrar(novoAutor);
		return new NovoAutorModel(novoAutor);
	}
}
