package com.example.Ma.dto;

import com.example.Ma.model.Produto;

public class ProdutoResponse {

	private Long id;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private Double preco;

	public ProdutoResponse(Produto p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.descricao = p.getDescricao();
		this.quantidade = p.getQuantidade();
		this.preco = p.getPreco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
