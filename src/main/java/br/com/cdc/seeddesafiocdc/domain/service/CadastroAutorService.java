package br.com.cdc.seeddesafiocdc.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;

@Service
/**
 * 2 ponto, não considerando classes Repository e lambdas como ponto de complexidade
 */
public class CadastroAutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Transactional
	public void cadastrar(Autor autor) {
		Optional<Autor> autorComEmail = autorRepository.findByEmail(autor.getEmail());
		if (autorComEmail.isPresent()) {
			throw new IllegalArgumentException("Email já utilizado");
		}
		autorRepository.save(autor);
	}
}
