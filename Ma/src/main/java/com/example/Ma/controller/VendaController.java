package com.example.Ma.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ma.dto.VendaRequest;
import com.example.Ma.dto.VendaResponse;

import com.example.Ma.service.VendasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendasService service;

    public VendaController(VendasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VendaResponse> registrar( @Valid @RequestBody VendaRequest request) {
        VendaResponse response = service.registrar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/relatorio")
    public ResponseEntity<Map<String, Object>> relatorio() {
        return ResponseEntity.ok(service.relatorio());
    }
}
