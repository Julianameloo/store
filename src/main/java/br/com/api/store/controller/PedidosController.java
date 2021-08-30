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

import br.com.api.store.dto.DetalhesPedidoDto;
import br.com.api.store.dto.PedidoDto;
import br.com.api.store.form.ItemForm;
import br.com.api.store.form.PedidoForm;
import br.com.api.store.model.Item;
import br.com.api.store.model.Pedido;
import br.com.api.store.repository.ClienteRepository;
import br.com.api.store.repository.ItemRepository;
import br.com.api.store.repository.PedidoRepository;
import br.com.api.store.repository.ProdutoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemRepository itemRepository;

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
		Pedido pedido = pedidoForm.converterParaPedido(clienteRepository, produtoRepository);
		pedidoRepository.save(pedido);

		URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new DetalhesPedidoDto(pedido));
	}

	@GetMapping
	public Page<PedidoDto> listar() {
		Page<Pedido> pedidos;
		Pageable paginacao = PageRequest.of(0, 10, Sort.by("id").ascending());

		pedidos = pedidoRepository.findAll(paginacao);
		return PedidoDto.converterParaPedidoDto(pedidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesPedidoDto> detalhar(@PathVariable int id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (pedido.isPresent()) {
			return ResponseEntity.ok(new DetalhesPedidoDto(pedido.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/itens/{id}")
	public ResponseEntity<Item> atualizarItens(@PathVariable int id, @RequestBody @Valid ItemForm itemForm) {
		Optional<Item> optionalItem = itemRepository.findById(id);

		if (optionalItem.isPresent()) {
			Item item = itemForm.atualizarItem(id, itemRepository, produtoRepository);
			itemRepository.save(item);

			return ResponseEntity.ok(item);
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PedidoDto> deletar(@PathVariable int id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);

		if (pedido.isPresent()) {
			pedidoRepository.deleteById(id);

			return ResponseEntity.ok(new PedidoDto(pedido.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
