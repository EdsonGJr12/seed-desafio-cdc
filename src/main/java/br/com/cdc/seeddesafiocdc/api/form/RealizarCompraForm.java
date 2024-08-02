package br.com.cdc.seeddesafiocdc.api.form;

import br.com.cdc.seeddesafiocdc.api.validation.Documento;
import br.com.cdc.seeddesafiocdc.api.validation.ExistEntity;
import br.com.cdc.seeddesafiocdc.domain.repository.EstadoRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.LivroRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.PaisRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Compra;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Estado;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pais;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * 5 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class RealizarCompraForm {

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@Documento
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotNull
	private String cidade;

	@NotNull
	@Positive
	@ExistEntity(fieldName = "id", classReference = Pais.class)
	private Long idPais;

	@Positive
	@ExistEntity(fieldName = "id", classReference = Estado.class)
	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;
	
	@NotNull
	@Valid
	private PagamentoCarrinhoForm carrinho;
	
	public Compra toEntity(PaisRepository paisRepository, LivroRepository livroRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.getReferenceById(this.idPais);
		Pedido pedido = this.carrinho.toEntity(livroRepository);
		
		this.carrinho.validarValorTotal(livroRepository);
		
		Compra compra = new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep, pedido);
		
		if (this.idEstado != null) {
			Estado estado = estadoRepository.getReferenceById(this.idEstado);
			compra.setEstado(estado );
		}
		
		return compra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public PagamentoCarrinhoForm getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(PagamentoCarrinhoForm carrinho) {
		this.carrinho = carrinho;
	}
}
