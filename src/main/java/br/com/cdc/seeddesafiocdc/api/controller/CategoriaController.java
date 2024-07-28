package br.com.cdc.seeddesafiocdc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdc.seeddesafiocdc.api.form.NovaCategoriaForm;
import br.com.cdc.seeddesafiocdc.api.model.NovaCategoriaModel;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;
import br.com.cdc.seeddesafiocdc.domain.service.CadastroCategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
/**
 * Total: 4 pontos
 */
public class CategoriaController {
	
	@Autowired
	private CadastroCategoriaService cadastroCategoriaService;

	@PostMapping
	public NovaCategoriaModel cadastrar(@RequestBody @Valid NovaCategoriaForm novaCategoriaForm) {
		Categoria novaCategoria = novaCategoriaForm.toEntity();
		cadastroCategoriaService.cadastrar(novaCategoria);
		return new NovaCategoriaModel(novaCategoria);
	}
}
