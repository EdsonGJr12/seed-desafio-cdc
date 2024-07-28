package br.com.cdc.seeddesafiocdc.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;

@Service
public class CadastroAutorService {
	
	@Autowired
	private AutorRepository autorRepository;

	@Transactional
	public void cadastrar(Autor autor) {
		autorRepository.save(autor);
	}
}
