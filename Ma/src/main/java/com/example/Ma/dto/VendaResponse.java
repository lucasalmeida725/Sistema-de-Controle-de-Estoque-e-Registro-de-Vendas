package com.example.Ma.dto;

import java.time.LocalDateTime;

public class VendaResponse {

	private Long id;
	private String produto;
	private Integer quantidade;
	private LocalDateTime data;

	public VendaResponse(Long id, String produto, Integer quantidade, LocalDateTime data) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public String getProduto() {
		return produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}
}
