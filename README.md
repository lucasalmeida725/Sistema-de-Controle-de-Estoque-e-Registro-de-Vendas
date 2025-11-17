Sistema de Gerenciamento de Vendas

Aplicação backend construída com Spring Boot para registrar produtos, vendas e controlar o estoque de forma simples e organizada. O foco do projeto foi treinar CRUD, relacionamentos, DTOs, tratamento de data/hora com LocalDateTime, regras de negócio e boas práticas no backend Java.

📌 Funcionalidades
Produtos

Listar todos os produtos — GET /produtos

Buscar por ID — GET /produtos/{id}

Criar produto — POST /produtos

Atualizar produto — PUT /produtos/{id}

Deletar produto — DELETE /produtos/{id}

Vendas

Registrar venda — POST /vendas

Salva a venda

Atualiza o estoque automaticamente

Registra data/hora da venda usando LocalDateTime

Listar todas as vendas — GET /vendas

Buscar venda específica — GET /vendas/{id}

📅 Registro de Data/Hora

Toda venda salva automaticamente o momento em que foi registrada:

A entidade possui LocalDateTime dataVenda

O valor é preenchido no construtor

O JSON retorna no formato padrão ISO (yyyy-MM-ddTHH:mm:ss)

Exemplo:

{
  "id": 1,
  "produto": "Monitor",
  "quantidade": 2,
  "dataVenda": "2025-11-17T14:32:10"
}

🛠 Tecnologias Utilizadas

Java 17

Spring Boot 3

Spring Data JPA

MySQL

Maven

DTOs para entrada e saída de dados

Camada Service com regras de negócio

Tratamento de erros padronizado

🎯 O que foi praticado no projeto

Estrutura clássica e organizada (Controller, Service, Repository, Model, DTO)

Construtores inteligentes para preencher data/hora automaticamente

Lógica de vendas com atualização de estoque

Boas práticas de validação e erros

JSON limpo e estruturado para retorno
