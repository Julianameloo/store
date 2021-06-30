package br.com.api.store.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.api.store.model.Produto;

public class ProdutoDto {

	private int id;
	private String nome;
	private BigDecimal preco;

	public ProdutoDto (Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public static Page<ProdutoDto> converterParaProdutoDto (Page<Produto> produtos) {
		return produtos.map(ProdutoDto::new);
	}

}
