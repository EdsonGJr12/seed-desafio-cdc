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

import br.com.cdc.seeddesafiocdc.domain.repository.AutorRepository;
import br.com.cdc.seeddesafiocdc.domain.repository.entity.Autor;

@ExtendWith(MockitoExtension.class)
public class CadastroAutorServiceTest {
	
	@Mock
	private AutorRepository autorRepository;
	
	@InjectMocks
	private CadastroAutorService cadastroAutorService;
	
	@Test
	public void deveRejeitarCasoEmailJaUtilizado() {
		Autor autor = new Autor();
		autor.setEmail("edson12.j@hotmail.com");
		
		when(autorRepository.findByEmail(anyString()))
			.thenReturn(Optional.of(autor));
		
		assertThrows(IllegalArgumentException.class, () -> {
			cadastroAutorService.cadastrar(autor);
		});
	}
}
