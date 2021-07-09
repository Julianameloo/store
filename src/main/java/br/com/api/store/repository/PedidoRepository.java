package br.com.api.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.store.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
