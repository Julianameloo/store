package br.com.api.store.form;

import java.math.BigDecimal;

import javax.validation.constraints.PositiveOrZero;

import br.com.api.store.anotations.ProdutoExistente;
import br.com.api.store.model.Item;
import br.com.api.store.model.Produto;
import br.com.api.store.repository.ItemRepository;
import br.com.api.store.repository.ProdutoRepository;

public class ItemForm {
	@ProdutoExistente
	private String produto_id;
	@PositiveOrZero
	private int quantidade;

	public String getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(String produto_id) {
		this.produto_id = produto_id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Item converterParaItem(ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getById(Integer.valueOf(this.produto_id));
		return new Item(produto, this.quantidade);
	}
	
	public Item atualizarItem(int id, ItemRepository itemRepository, ProdutoRepository produtoRepository) {
		Item item = itemRepository.getById(id);
		Produto produto = produtoRepository.getById(Integer.valueOf(this.produto_id));
		item.setProduto(produto);
		item.setQuantidade(this.quantidade);
		BigDecimal preco = produto.getPreco().multiply(new BigDecimal(this.quantidade));
		item.setPrecoTotal(preco);
		return item;
	}
	
}
