package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdc.seeddesafiocdc.api.form.NovoLivroForm;
import br.com.cdc.seeddesafiocdc.api.model.NovoLivroModel;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import br.com.cdc.seeddesafiocdc.domain.service.CadastroLivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private CadastroLivroService cadastroLivroService;

	@PostMapping
	public NovoLivroModel cadastrar(@RequestBody @Valid NovoLivroForm novoLivroForm) {
		Livro novoLivro = cadastroLivroService.cadastrar(novoLivroForm);
		return new NovoLivroModel(novoLivro);
	}
}
