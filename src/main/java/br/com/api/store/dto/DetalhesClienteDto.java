package br.com.api.store.dto;

import br.com.api.store.model.Cliente;

public class DetalhesClienteDto {
	private String nome;
	private String sobrenome;
	private String genero;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;
	private String email;

	public DetalhesClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.genero = cliente.getGenero().toString();
		this.endereco = cliente.getEndereco();
		this.cidade = cliente.getCidade();
		this.estado = cliente.getEstado();
		this.cep = cliente.getCep();
		this.email = cliente.getEmail();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
