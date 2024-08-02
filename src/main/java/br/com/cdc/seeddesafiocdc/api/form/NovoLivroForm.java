package br.com.cdc.seeddesafiocdc.api.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.cdc.seeddesafiocdc.api.validation.ExistEntity;
import br.com.cdc.seeddesafiocdc.api.validation.UniqueValue;
import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.CategoriaRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Livro;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * 3 ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class NovoLivroForm {

	@NotBlank
	@UniqueValue(fieldName = "titulo", classReference = Livro.class)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroPaginas;

	@NotBlank
	@UniqueValue(fieldName = "isbn", classReference = Livro.class)
	private String isbn;

	@Future
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@Positive
	@ExistEntity(fieldName = "id", classReference = Categoria.class)
	private Long idCategoria;

	@NotNull
	@Positive
	@ExistEntity(fieldName = "id", classReference = Autor.class)
	private Long idAutor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Livro toEntity(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Categoria categoria = categoriaRepository.getReferenceById(this.idCategoria);
		Autor autor = autorRepository.getReferenceById(idAutor);
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}
}
