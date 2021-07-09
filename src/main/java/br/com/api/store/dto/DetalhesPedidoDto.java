package br.com.api.store.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.api.store.model.Item;
import br.com.api.store.model.Pedido;

public class DetalhesPedidoDto {
	private int id;
	private int cliente_id;
	private String preco;
	private LocalDate data;
	private List<Item> itens;

	public DetalhesPedidoDto (Pedido pedido) {
		this.id = pedido.getId();
		this.cliente_id = pedido.getCliente().getId();
		this.preco = pedido.getPreco().toString();
		this.data = pedido.getDataPedido();
		this.itens = pedido.getItens();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
