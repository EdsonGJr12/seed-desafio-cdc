package br.com.cdc.seeddesafiocdc.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdc.seeddesafiocdc.domain.repository.CategoriaRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;

@Service
/**
 * Total: 3 Pontos
 */
public class CadastroCategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	public void cadastrar(Categoria novaCategoria) {
		Optional<Categoria> categoriaComNome = categoriaRepository.findByNome(novaCategoria.getNome());
		if (categoriaComNome.isPresent()) {
			throw new IllegalArgumentException("Categoria com esse nome já cadastrada");
		}
		categoriaRepository.save(novaCategoria);
	}
}
