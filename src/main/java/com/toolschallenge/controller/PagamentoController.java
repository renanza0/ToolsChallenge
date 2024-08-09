package com.toolschallenge.controller;

import com.toolschallenge.dto.PagamentoRequestDTO;
import com.toolschallenge.dto.PagamentoResponseDTO;
import com.toolschallenge.dto.EstornoResponseDTO;
import com.toolschallenge.model.Transacao;
import com.toolschallenge.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> realizarPagamento(@RequestBody PagamentoRequestDTO request) {
        PagamentoResponseDTO response = transacaoService.processarPagamento(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/estorno")
    public ResponseEntity<EstornoResponseDTO> realizarEstorno(@PathVariable String id) {
        EstornoResponseDTO response = transacaoService.processarEstorno(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> consultarPagamento(@PathVariable String id) {
        PagamentoResponseDTO response = transacaoService.consultarPagamento(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Map<String, Transacao>> consultarTodos() {
        Map<String, Transacao> response = transacaoService.consultarTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}