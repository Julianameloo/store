package br.com.api.store.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import br.com.api.store.anotations.CategoriaExistente;
import br.com.api.store.model.Categoria;
import br.com.api.store.model.Estoque;
import br.com.api.store.model.Produto;
import br.com.api.store.repository.CategoriaRepository;

public class ProdutoForm {
	@NotEmpty
	private String nome;
	@NotEmpty
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String preco;
	@NotEmpty
	@CategoriaExistente
	private String categoria;
	@PositiveOrZero
	private int quantidadeDisponivel;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
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

	public Produto converterParaProduto(CategoriaRepository categoriaRepository) {
		Estoque estoque = new Estoque();
		estoque.setQuantidade(quantidadeDisponivel);
		Categoria categoriaClass = categoriaRepository.findByNome(categoria);

		return new Produto(nome, new BigDecimal(preco), categoriaClass, estoque);
	}

}
