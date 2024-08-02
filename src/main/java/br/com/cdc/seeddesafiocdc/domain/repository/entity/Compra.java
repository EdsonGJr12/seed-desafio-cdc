package br.com.cdc.seeddesafiocdc.domain.repository.entity;

import java.math.BigDecimal;

import br.com.cdc.seeddesafiocdc.domain.constants.StatusCompra;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "tb_compra")
/**
 * 6 Pontos, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String nome;

	private String sobrenome;

	private String documento;

	private String endereco;

	private String complemento;

	private String cidade;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	private String telefone;

	private String cep;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	private StatusCompra status;
	
	@ManyToOne
	@JoinColumn(name = "id_cupom_desconto")
	private CupomDesconto cupomDesconto;
	
	private BigDecimal valorCompra;
	
	@Deprecated
	public Compra() {}

	public Compra(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, String telefone, String cep, Pedido pedido) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
		this.pedido = pedido;
		this.valorCompra = pedido.getTotal();
		this.status = StatusCompra.INICIADA;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public StatusCompra getStatus() {
		return status;
	}

	public void aplicarCupomDesconto(CupomDesconto cupom) {
		if (this.isCupomAplicado()) {
			throw new IllegalArgumentException("Já existe um cupom associado a essa compra");
		}
		
		this.cupomDesconto = cupom;
		
		BigDecimal fatorDesconto = this.cupomDesconto.getPercentualDesconto().divide(BigDecimal.valueOf(100));
		BigDecimal valorDesconto = fatorDesconto.multiply(this.valorCompra);
		
		this.valorCompra = this.valorCompra.subtract(valorDesconto);
	}

	public boolean isCupomAplicado() {
		return this.cupomDesconto != null;
	}
	
	public BigDecimal getValorCompra() {
		return valorCompra;
	}
}
