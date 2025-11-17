package com.example.Ma.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VendaRequest {

	@NotNull
	private Long produtoId;
	
	@Min(1)
	private Integer quantidade;

	public VendaRequest(@NotNull Long produtoId, @Min(1) Integer quantidade) {
		super();
		this.produtoId = produtoId;
		this.quantidade = quantidade;
	}

	public VendaRequest() {
		super();
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
