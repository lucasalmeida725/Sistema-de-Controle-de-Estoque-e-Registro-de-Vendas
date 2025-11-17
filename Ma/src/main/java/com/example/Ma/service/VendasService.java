package com.example.Ma.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Ma.dto.VendaRequest;
import com.example.Ma.dto.VendaResponse;
import com.example.Ma.model.Produto;
import com.example.Ma.model.Vendas;
import com.example.Ma.repository.ProdutoRepository;
import com.example.Ma.repository.VendaRepository;

@Service
public class VendasService {

	private final VendaRepository vendaRepository;
	private final ProdutoRepository produtoRepository;

	public VendasService(VendaRepository vendaRepository, ProdutoRepository produtoRepository) {
		super();
		this.vendaRepository = vendaRepository;
		this.produtoRepository = produtoRepository;
	}

	public VendaResponse registrar(VendaRequest dto) {
		Produto produto = produtoRepository.findById(dto.getProdutoId())
				.orElseThrow(() -> new RuntimeException("Produto não existe"));

		if (produto.getQuantidade() < dto.getQuantidade()) {
			throw new RuntimeException("Estoque insuficiente");
		}
		produto.setQuantidade(produto.getQuantidade() - dto.getQuantidade());
		produtoRepository.save(produto);

		Vendas venda = new Vendas(produto, dto.getQuantidade());
		Vendas salvar = vendaRepository.save(venda);

		return new VendaResponse(salvar.getId(), salvar.getProduto().getNome(), salvar.getQuantidade(),
				salvar.getDataVenda());
	}
	 public Map<String, Object> relatorio() {

	        List<Vendas> vendas = vendaRepository.findAll();

	        long totalVendas = vendas.size();

	        String produtoMaisVendido = vendas.stream()
	                .collect(Collectors.groupingBy(v -> v.getProduto().getNome(), Collectors.summingInt(Vendas::getQuantidade)))
	                .entrySet()
	                .stream()
	                .max(Map.Entry.comparingByValue())
	                .map(Map.Entry::getKey)
	                .orElse("Nenhuma venda");

	        long totalProdutos = produtoRepository.count();

	        return Map.of(
	                "totalProdutos", totalProdutos,
	                "totalVendas", totalVendas,
	                "produtoMaisVendido", produtoMaisVendido
	        );
	    }
	 public List<VendaResponse> listar() {
	        return vendaRepository.findAll()
	                .stream()
	                .map(v -> new VendaResponse(
	                        v.getId(),
	                        v.getProduto().getNome(),
	                        v.getQuantidade(),
	                        v.getDataVenda()
	                ))
	                .collect(Collectors.toList());
	    }
}
