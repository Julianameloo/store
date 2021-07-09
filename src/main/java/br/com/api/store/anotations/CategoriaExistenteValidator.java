package br.com.api.store.anotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.api.store.model.Categoria;
import br.com.api.store.repository.CategoriaRepository;

public class CategoriaExistenteValidator implements ConstraintValidator<CategoriaExistente, String>{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
    public void initialize(CategoriaExistente categoria) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(String nomeCategoria,
      ConstraintValidatorContext cxt) {
    	if (nomeCategoria ==  null) return false;
        Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
        return categoria != null;
        
    }

}
