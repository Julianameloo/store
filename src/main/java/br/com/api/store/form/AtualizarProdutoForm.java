package br.com.api.store.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.com.api.store.model.Produto;
import br.com.api.store.repository.ProdutoRepository;

public class AtualizarProdutoForm {
	@NotEmpty
	private String nome;
	@NotEmpty
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String preco;

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
	
	public Produto atualizarProduto (int id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getById(id);
		produto.setNome(nome);
		produto.setPreco(new BigDecimal(preco));
		
		return produto;
	}

}
