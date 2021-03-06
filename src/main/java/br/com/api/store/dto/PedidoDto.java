package br.com.api.store.dto;

import org.springframework.data.domain.Page;

import br.com.api.store.model.Pedido;

public class PedidoDto {
	private int id;
	private int cliente_id;
	private String preco;

	public PedidoDto (Pedido pedido) {
		this.id = pedido.getId();
		this.cliente_id = pedido.getCliente().getId();
		this.preco = pedido.getPreco().toString();
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
	
	public static Page<PedidoDto> converterParaPedidoDto(Page<Pedido> pedidos) {
		return pedidos.map(PedidoDto::new);
	}

}
