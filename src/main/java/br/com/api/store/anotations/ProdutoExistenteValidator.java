package br.com.api.store.anotations;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.api.store.model.Produto;
import br.com.api.store.repository.ProdutoRepository;

public class ProdutoExistenteValidator implements ConstraintValidator<ProdutoExistente, String> {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
    public void initialize(ProdutoExistente cliente) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(String idProduto,
      ConstraintValidatorContext cxt) {
        if (idProduto == null) return false;
    	Optional<Produto> produto = produtoRepository.findById(Integer.valueOf(idProduto));
        
        if (produto.isPresent()) {
        	return true;
        }
        return false;
        
    }
}
