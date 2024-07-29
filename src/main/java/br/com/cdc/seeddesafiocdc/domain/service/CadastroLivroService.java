package br.com.cdc.seeddesafiocdc.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cdc.seeddesafiocdc.api.form.NovoLivroForm;
import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.CategoriaRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;

@Service
public class CadastroLivroService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public Livro cadastrar(NovoLivroForm novoLivroForm) {
		Optional<Categoria> categoria = categoriaRepository.findById(novoLivroForm.getIdCategoria());
		if (categoria.isEmpty()) {
			throw new IllegalArgumentException("Categoria não existente");
		}
		
		Optional<Autor> autor = autorRepository.findById(novoLivroForm.getIdAutor());
		if (autor.isEmpty()) {
			throw new IllegalArgumentException("Autor não existente");
		}
		
		Livro novoLivro = new Livro();
		novoLivro.setCategoria(categoria.get());
		novoLivro.setAutor(autor.get());
		novoLivro.setTitulo(novoLivroForm.getTitulo());
		novoLivro.setResumo(novoLivroForm.getResumo());
		novoLivro.setSumario(novoLivroForm.getSumario());
		novoLivro.setPreco(novoLivroForm.getPreco());
		novoLivro.setNumeroPaginas(novoLivroForm.getNumeroPaginas());
		novoLivro.setIsbn(novoLivroForm.getIsbn());
		novoLivro.setDataPublicacao(novoLivroForm.getDataPublicacao());
		
		livroRepository.save(novoLivro);
		
		return novoLivro;
	}

}
