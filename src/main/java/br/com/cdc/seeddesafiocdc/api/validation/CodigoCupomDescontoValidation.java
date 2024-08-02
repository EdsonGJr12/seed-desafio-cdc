package br.com.cdc.seeddesafiocdc.api.validation;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cdc.seeddesafiocdc.domain.repository.CupomDescontoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodigoCupomDescontoValidation implements ConstraintValidator<CodigoCupomDesconto, String> {
	
	@Autowired
	private CupomDescontoRepository cupomDescontoRepository;

	@Override
	public boolean isValid(String codigo, ConstraintValidatorContext context) {
		return codigo == null || cupomDescontoRepository.existsCupomValido(codigo);
	}
}
