package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cdc.seeddesafiocdc.api.form.NovoEstadoForm;
import br.com.cdc.seeddesafiocdc.api.form.NovoPaisForm;
import br.com.cdc.seeddesafiocdc.domain.repository.PaisRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Pais;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paises")
/**
 *  4 pontos
 * 
 */
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public void cadastrar(@RequestBody @Valid NovoPaisForm novoPaisForm) {
		paisRepository.save(novoPaisForm.toEntity());
	}
	
	@PostMapping("/{idPais}/estados")
	@Transactional
	public void cadastrarEstado(@PathVariable Long idPais, @RequestBody @Valid NovoEstadoForm novoEstadoForm) {
		Pais pais = paisRepository.findById(idPais)
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		pais.adicionarEstado(novoEstadoForm.toEntity());
	}
}
