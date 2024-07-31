package br.com.cdc.seeddesafiocdc.domain.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "tb_pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_pais")
	private List<Estado> estados = new ArrayList<>();

	@Deprecated
	public Pais() {
		
	}
	
	public Pais(String nome) {
		this.nome = nome;
	}
	
	public void adicionarEstado(Estado estado) {
		this.estados.add(estado);
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
}
