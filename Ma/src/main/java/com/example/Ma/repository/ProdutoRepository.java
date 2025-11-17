package com.example.Ma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Ma.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

	Optional<Produto>findByNomeContainingIgnoreCase(String nome);
}
