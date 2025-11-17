package com.example.Ma.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoRequest {
	@jakarta.validation.constraints.NotBlank(message = "Nome obrigatorio")
	private String nome;
	@jakarta.validation.constraints.NotBlank(message = "Descricao Obrigatoria")
	private String descricao;
	@PositiveOrZero
	private Integer quantidade;
	@DecimalMin(value = "0.0", inclusive = false)
	private Double preco;

	public ProdutoRequest(@NotBlank(message = "Nome obrigatorio") String nome,
			@NotBlank(message = "Descricao Obrigatoria") String descricao, @PositiveOrZero Integer quantidade,
			@DecimalMin(value = "0.0", inclusive = false) Double preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ProdutoRequest() {
		super();
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
