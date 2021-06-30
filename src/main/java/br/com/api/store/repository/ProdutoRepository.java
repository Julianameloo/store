package br.com.api.store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.store.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Integer>{
	
	public Page<Produto> findAll (Pageable paginacao);
	
}
