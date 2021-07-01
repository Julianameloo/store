package br.com.api.store.form;

import javax.validation.constraints.Pattern;

import br.com.api.store.model.Cliente;
import br.com.api.store.repository.ClienteRepository;

public class AtualizarClienteForm {
	private String nome;
	private String sobrenome;
	private String endereco;
	private String cidade;
	private String estado;
	@Pattern(regexp = "^\\d+{5}\\-\\d+{3}")
	private String cep;

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
	
	public Cliente atualizarCliente(int id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getById(id);
		
		if (!(this.nome == null) && !this.nome.isBlank()) cliente.setNome(nome); 
		if (!(this.sobrenome == null) && !this.sobrenome.isBlank()) cliente.setSobrenome(sobrenome);
		if (!(this.endereco == null) && !this.endereco.isBlank()) cliente.setEndereco(endereco);
		if (!(this.cidade == null) && !this.cidade.isBlank()) cliente.setCidade(cidade);
		if (!(this.estado == null) && !this.estado.isBlank()) cliente.setEstado(estado);
		if (!(this.cep == null) && !this.cep.isBlank()) cliente.setCep(cep);
		
		return cliente;
	}

}
