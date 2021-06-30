package br.com.api.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.store.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{

	Categoria findByNome(String categoria);

}
