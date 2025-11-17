package com.example.Ma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Ma.dto.ProdutoRequest;
import com.example.Ma.dto.ProdutoResponse;
import com.example.Ma.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService service;

	public ProdutoController(ProdutoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProdutoResponse> criar(@Valid @RequestBody ProdutoRequest dto) {
		ProdutoResponse response = service.criarProduto(dto);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponse> buscar(@PathVariable Long id) {
		ProdutoResponse response = service.ProcurarId(id);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponse>> listar() {
		List<ProdutoResponse> lista = service.Listar();
		return ResponseEntity.ok(lista);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest dto, @PathVariable Long id) {
		ProdutoResponse response = service.Atualizar(dto, id);
		return ResponseEntity.ok(response);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{id}/aumentar/{qnt}")
	public ResponseEntity<ProdutoResponse> aumentar(@PathVariable Long id, @PathVariable int qnt) {
		ProdutoResponse response = service.aumentar(id, qnt);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/{id}/diminuir/{qnt}")
	public ResponseEntity<ProdutoResponse> diminuir(@PathVariable Long id, @PathVariable int qnt) {
		ProdutoResponse response = service.Diminuir(id, qnt);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}/estoque")
	public ResponseEntity<Integer> verificar(@PathVariable Long id) {
		int quantidade = service.verificarEstoque(id);
		return ResponseEntity.ok(quantidade);
	}
}
