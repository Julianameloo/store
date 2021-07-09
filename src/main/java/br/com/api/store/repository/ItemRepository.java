package br.com.api.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.store.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
