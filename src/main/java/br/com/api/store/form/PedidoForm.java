package br.com.api.store.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.api.store.anotations.ClienteExistente;
import br.com.api.store.model.Cliente;
import br.com.api.store.model.Item;
import br.com.api.store.model.Pedido;
import br.com.api.store.repository.ClienteRepository;
import br.com.api.store.repository.ProdutoRepository;

public class PedidoForm {
	@ClienteExistente
	private String cliente_id;
	@NotNull @NotEmpty
	private List<@Valid ItemForm> itens;

	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	public List<ItemForm> getItens() {
		return itens;
	}

	public void setItens(List<ItemForm> itens) {
		this.itens = itens;
	}

	
	public Pedido converterParaPedido(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
		Cliente cliente = clienteRepository.getById(Integer.valueOf(this.cliente_id));
		List<Item> novosItens = new ArrayList<>();
		BigDecimal preco = new BigDecimal(0);
		for (ItemForm item : this.itens) {
			Item novoItem = item.converterParaItem(produtoRepository);
			novosItens.add(novoItem);
			preco = preco.add(novoItem.getPrecoTotal());
		}
		return new Pedido(cliente, novosItens, preco);	
	}
}
