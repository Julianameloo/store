package br.com.api.store.anotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.api.store.model.Genero;

public class GeneroNaoExistenteValidator implements ConstraintValidator<GeneroNaoExistente, String> {
	@Override
    public void initialize(GeneroNaoExistente genero) {
    }

    @Override
    public boolean isValid(String nomeGenero,
      ConstraintValidatorContext cxt) {
    	if (nomeGenero == null) {
    		return false;
    	}
    	return Genero.contains(nomeGenero.toUpperCase());
    }
}
