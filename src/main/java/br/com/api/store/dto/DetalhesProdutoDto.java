package br.com.api.store.dto;

import java.math.BigDecimal;

import br.com.api.store.model.Categoria;
import br.com.api.store.model.Estoque;
import br.com.api.store.model.Produto;

public class DetalhesProdutoDto {

	private int id;
	private String nome;
	private BigDecimal preco;
	private String categoria;
	private int quantidadeDisponivel;

	public DetalhesProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		//Categoria categoriaClass = produto.getCategoria();
		//this.categoria = categoriaClass.getNome();
		//Estoque estoque = produto.getEstoque();
		//this.quantidadeDisponivel = estoque.getQuantidade();
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

}
