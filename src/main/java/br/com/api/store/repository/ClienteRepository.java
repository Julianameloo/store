package br.com.api.store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.store.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	public Page<Cliente> findAll(Pageable paginacao);

	public Cliente findByEmail(String email);
}
