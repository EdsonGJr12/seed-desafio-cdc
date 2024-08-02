package br.com.cdc.seeddesafiocdc.api.validation;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistEntityValidation implements ConstraintValidator<ExistEntity, Object> {
	
	private String fieldName;
	private Class<?> classReference;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(ExistEntity params) {
		fieldName = params.fieldName();
		classReference = params.classReference();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from " + classReference.getName() 
			+ " where " + fieldName + " = :value");
		query.setParameter("value", value);
		List<?> result = query.getResultList();
		return !result.isEmpty();
	}

}
