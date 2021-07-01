package br.com.api.store.dto;

import org.springframework.data.domain.Page;

import br.com.api.store.model.Cliente;

public class ClienteDto {
	private int id;
	private String nome;
	private String sobrenome;

	public ClienteDto() {
	}

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public static Page<ClienteDto> converterParaClienteDto(Page<Cliente> clientes) {
		return clientes.map(ClienteDto::new);
	}

}
