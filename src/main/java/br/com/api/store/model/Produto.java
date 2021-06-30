package br.com.api.store.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Enumerated(EnumType.STRING)
	@ManyToOne
	private Categoria categoria;
	@OneToOne(cascade = CascadeType.ALL)
	private Estoque estoque;
	private BigDecimal preco;

	public Produto () {
		
	}
	
	public Produto (String nome, BigDecimal preco, Categoria categoria, Estoque estoque) {
		this.nome = nome;
		this.preco = preco;
		this.categoria = categoria;
		this.estoque = estoque;
	}
	
	public String getNome() {
		return nome;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

}
