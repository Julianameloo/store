package br.com.api.store.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import br.com.api.store.anotations.GeneroNaoExistente;
import br.com.api.store.anotations.UsuarioExistente;
import br.com.api.store.model.Cliente;
import br.com.api.store.model.Genero;
import br.com.api.store.model.Perfil;
import br.com.api.store.repository.ClienteRepository;

public class ClienteForm {
	@NotEmpty
	private String nome;
	@NotEmpty
	private String sobrenome;
	@GeneroNaoExistente
	private String genero;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String cidade;
	@NotEmpty
	private String estado;
	@NotEmpty @Pattern(regexp = "^\\d+{5}\\-\\d+{3}")
	private String cep;
	@Email
	@UsuarioExistente
	private String email;
	@NotEmpty
	private String senha;
	private String cartaoCredito;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente converterParaCliente(ClienteRepository clienteRepository) {
		return new Cliente(this.nome, this.sobrenome, Enum.valueOf(Genero.class, genero.toUpperCase()), endereco, cidade, estado, cep,
				email, senha, cartaoCredito, new Perfil("CLIENT"));
	}

}
