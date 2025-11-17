package com.example.Ma.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer quantidade;
	private LocalDateTime dataVenda;
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Vendas() {
		super();
	}

	public Vendas(Produto produto, Integer quantidade) {
		super();
		this.quantidade = quantidade;
		this.produto = produto;
		this.dataVenda = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto protudo) {
		this.produto = protudo;
	}

}
