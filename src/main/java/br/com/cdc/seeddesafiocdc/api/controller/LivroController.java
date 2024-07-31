package br.com.cdc.seeddesafiocdc.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdc.seeddesafiocdc.api.form.NovoLivroForm;
import br.com.cdc.seeddesafiocdc.api.model.LivroDetalheModel;
import br.com.cdc.seeddesafiocdc.api.model.LivroModel;
import br.com.cdc.seeddesafiocdc.api.model.NovoLivroModel;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import br.com.cdc.seeddesafiocdc.domain.service.CadastroLivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
/**
 * 6 Pontos
 */
public class LivroController {
	
	@Autowired
	private CadastroLivroService cadastroLivroService;

	@PostMapping
	public NovoLivroModel cadastrar(@RequestBody @Valid NovoLivroForm novoLivroForm) {
		Livro novoLivro = cadastroLivroService.cadastrar(novoLivroForm);
		return new NovoLivroModel(novoLivro);
	}
	
	@GetMapping
	public List<LivroModel> pesquisar() {
		List<Livro> livros = cadastroLivroService.pesquisar();
		return livros.stream()
				.map(LivroModel::new)
				.toList();
	}
	
	@GetMapping("/{idLivro}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long idLivro) {
		Optional<Livro> livro = cadastroLivroService.buscarPorId(idLivro);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroDetalheModel(livro.get()));
		} 
		
		return ResponseEntity.notFound().build();
	}
}
