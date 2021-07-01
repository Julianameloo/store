package br.com.api.store.anotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.api.store.model.Cliente;
import br.com.api.store.repository.ClienteRepository;

public class UsuarioExistenteValidator implements ConstraintValidator<UsuarioExistente, String> {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
    public void initialize(UsuarioExistente usuario) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(String email,
      ConstraintValidatorContext cxt) {
    	if (email == null) return false;
        Cliente cliente = clienteRepository.findByEmail(email);
        return cliente == null;   
    }
}
