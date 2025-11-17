package com.example.Ma.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Ma.dto.ProdutoRequest;
import com.example.Ma.dto.ProdutoResponse;
import com.example.Ma.model.Produto;
import com.example.Ma.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository repository;

	public ProdutoService(ProdutoRepository repository) {
		super();
		this.repository = repository;
	}

	public ProdutoResponse criarProduto(ProdutoRequest dto) {
		Produto produto = new Produto();
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());

		Produto salvar = repository.save(produto);
		return new ProdutoResponse(salvar);
	}

	public ProdutoResponse ProcurarId(Long id) {
		Produto produto = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto" + id + "não foi encontrado"));
		return new ProdutoResponse(produto);
	}

	public List<ProdutoResponse> Listar() {
		return repository.findAll().stream().map(ProdutoResponse::new).collect(Collectors.toList());
	}

	public void deletar(long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Esse" + id + "não existe");
		}
		repository.deleteById(id);
	}

	public ProdutoResponse Atualizar(ProdutoRequest dto, Long id) {
		Produto produto = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto" + id + "não existe"));
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());

		Produto atualizar = repository.save(produto);
		return new ProdutoResponse(atualizar);

	}

	public ProdutoResponse aumentar(Long id, int estoque) {
		Produto produto = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto" + id + "nao existe"));

		produto.setQuantidade(produto.getQuantidade() + estoque);
		Produto aumentar = repository.save(produto);
		return new ProdutoResponse(aumentar);
	}

	public ProdutoResponse Diminuir(Long id, int estoque) {
		Produto produto = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto" + id + "nao existe"));
		if (produto.getQuantidade() < estoque) {
			throw new RuntimeException("Estoque insuficiente para remover");
		}
		produto.setQuantidade(produto.getQuantidade() - estoque);
		return new ProdutoResponse(produto);
	}

	public int verificarEstoque(Long id) {
		Produto produto = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto " + id + " não existe"));

		return produto.getQuantidade();
	}

}
