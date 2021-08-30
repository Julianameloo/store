package br.com.api.store.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.api.store.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	public Page<Cliente> findAll(Pageable paginacao);

	public Cliente findByEmail(String email);
	
	@Query("select c from Cliente c where c.email = :email")
	public Optional<Cliente> findByEmailOptional(@Param("email") String email);
}
