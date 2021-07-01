package br.com.api.store.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.store.dto.ClienteDto;
import br.com.api.store.dto.DetalhesClienteDto;
import br.com.api.store.form.AtualizarClienteForm;
import br.com.api.store.form.ClienteForm;
import br.com.api.store.model.Cliente;
import br.com.api.store.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping
	public ResponseEntity<ClienteDto> criar (@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteForm.converterParaCliente(clienteRepository);
		clienteRepository.save(cliente);
		
		//devolve no location header a uri do recurso criado
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@GetMapping
	public Page<ClienteDto> listar() {
		Page<Cliente> clientes;
		Pageable paginacao = PageRequest.of(0, 10, Sort.by("id").ascending());

		clientes = clienteRepository.findAll(paginacao);
		return ClienteDto.converterParaClienteDto(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesClienteDto> detalhar (@PathVariable int id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesClienteDto(cliente.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDto> atualizar(@PathVariable int id,
			@RequestBody @Valid AtualizarClienteForm clienteForm) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		
		if (optionalCliente.isPresent()) {
			Cliente cliente = clienteForm.atualizarCliente(id, clienteRepository);
			clienteRepository.save(cliente);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDto> deletar (@PathVariable int id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
			
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
