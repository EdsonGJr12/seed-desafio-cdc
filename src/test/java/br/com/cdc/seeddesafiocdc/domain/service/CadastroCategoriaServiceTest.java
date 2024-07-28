package br.com.cdc.seeddesafiocdc.domain.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.cdc.seeddesafiocdc.domain.repository.CategoriaRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Categoria;

@ExtendWith(MockitoExtension.class)
public class CadastroCategoriaServiceTest {
	
	@Mock
	private CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private CadastroCategoriaService cadastroCategoriaService;
	
	@Test
	public void deveRejeitarCasoEmailJaUtilizado() {
		Categoria categoria = new Categoria("Programação"); 
		
		when(categoriaRepository.findByNome(anyString()))
			.thenReturn(Optional.of(categoria));
		
		assertThrows(IllegalArgumentException.class, () -> {
			cadastroCategoriaService.cadastrar(categoria);
		});
	}
}
