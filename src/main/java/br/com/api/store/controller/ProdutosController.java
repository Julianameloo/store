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

import br.com.api.store.dto.DetalhesProdutoDto;
import br.com.api.store.dto.ProdutoDto;
import br.com.api.store.form.AtualizarProdutoForm;
import br.com.api.store.form.ProdutoForm;
import br.com.api.store.model.Produto;
import br.com.api.store.repository.CategoriaRepository;
import br.com.api.store.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
		Produto produto = produtoForm.converterParaProduto(categoriaRepository);
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@GetMapping
	public Page<ProdutoDto> listar() {
		Page<Produto> produtos;
		Pageable paginacao = PageRequest.of(0, 10, Sort.by("id").ascending());

		produtos = produtoRepository.findAll(paginacao);

		return ProdutoDto.converterParaProdutoDto(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesProdutoDto> detalhar(@PathVariable int id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesProdutoDto(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable int id,
			@RequestBody @Valid AtualizarProdutoForm produtoForm) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			Produto produto = produtoForm.atualizarProduto(id, produtoRepository);
			produtoRepository.save(produto);
			return ResponseEntity.ok(produto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletar(@PathVariable int id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			produtoRepository.deleteById(id);

			return ResponseEntity.ok().body(produto.get());
		}

		return ResponseEntity.notFound().build();
	}

}
