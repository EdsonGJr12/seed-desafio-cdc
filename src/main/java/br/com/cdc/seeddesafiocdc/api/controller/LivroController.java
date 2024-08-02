package br.com.cdc.seeddesafiocdc.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cdc.seeddesafiocdc.api.form.NovoLivroForm;
import br.com.cdc.seeddesafiocdc.api.model.LivroDetalheModel;
import br.com.cdc.seeddesafiocdc.api.model.LivroModel;
import br.com.cdc.seeddesafiocdc.api.model.NovoLivroModel;
import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.CategoriaRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
/**
 * 5 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class LivroController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public NovoLivroModel cadastrar(@RequestBody @Valid NovoLivroForm novoLivroForm) {
		Livro livro = novoLivroForm.toEntity(categoriaRepository, autorRepository);
		Livro novoLivro = livroRepository.save(livro);
		return new NovoLivroModel(novoLivro);
	}
	
	@GetMapping
	public List<LivroModel> pesquisar() {
		List<Livro> livros = livroRepository.findAll();
		return livros.stream()
				.map(LivroModel::new)
				.toList();
	}
	
	@GetMapping("/{idLivro}")
	public LivroDetalheModel buscarPorId(@PathVariable Long idLivro) {
		Livro livro = livroRepository.findById(idLivro)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		return new LivroDetalheModel(livro);
	}
}
