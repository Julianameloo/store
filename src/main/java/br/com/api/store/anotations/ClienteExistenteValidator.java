package br.com.api.store.anotations;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.api.store.model.Cliente;
import br.com.api.store.repository.ClienteRepository;

public class ClienteExistenteValidator implements ConstraintValidator<ClienteExistente, String>{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
    public void initialize(ClienteExistente cliente) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(String idCliente,
      ConstraintValidatorContext cxt) {
    	if (idCliente == null) return false;
        Optional<Cliente> cliente = clienteRepository.findById(Integer.valueOf(idCliente));
        
        if (cliente.isPresent()) {
        	return true;
        }
        return false;
        
    }
}
