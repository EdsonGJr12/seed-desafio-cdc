package br.com.cdc.seeddesafiocdc.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {CodigoCupomDescontoValidation.class})
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CodigoCupomDesconto {
	String message() default "Cupom inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
