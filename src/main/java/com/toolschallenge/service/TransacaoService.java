package com.toolschallenge.service;

import com.toolschallenge.dto.EstornoResponseDTO;
import com.toolschallenge.dto.PagamentoRequestDTO;
import com.toolschallenge.dto.PagamentoResponseDTO;
import com.toolschallenge.model.Transacao;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TransacaoService {

	private Map<String, Transacao> transacoes = new HashMap<>();

	public Transacao realizarPagamento(Transacao transacao) {
		// Simula processamento de pagamento
		transacao.setId(UUID.randomUUID().toString());
		transacao.setStatus("AUTORIZADO");
		transacao.setNsu(UUID.randomUUID().toString());
		transacao.setCodigoAutorizacao(UUID.randomUUID().toString());
		transacoes.put(transacao.getId(), transacao);
		return transacao;
	}

	public Transacao estornarPagamento(String id) {
		// Simula estorno de pagamento
		Transacao transacao = transacoes.get(id);
		if (transacao != null) {
			transacao.setStatus("CANCELADO");
		}
		return transacao;
	}

	public PagamentoResponseDTO processarPagamento(PagamentoRequestDTO request) {
		String id = UUID.randomUUID().toString();
		Transacao transacao = new Transacao();
		transacao.setId(id);
		transacao.setCartao(request.getCartao());
		transacao.setValor(request.getValor());
		transacao.setDataHora(request.getDataHora());
		transacao.setEstabelecimento(request.getEstabelecimento());
		transacao.setTipo(request.getTipo());
		transacao.setParcelas(request.getParcelas());
		transacao.setStatus("AUTORIZADO");
		transacao.setNsu("1234567890");
		transacao.setCodigoAutorizacao("147258369");

		transacoes.put(id, transacao);

		PagamentoResponseDTO response = new PagamentoResponseDTO();
		response.setId(transacao.getId());
		response.setCartao(transacao.getCartao());
		response.setValor(transacao.getValor());
		response.setDataHora(transacao.getDataHora());
		response.setEstabelecimento(transacao.getEstabelecimento());
		response.setNsu(transacao.getNsu());
		response.setCodigoAutorizacao(transacao.getCodigoAutorizacao());
		response.setStatus(transacao.getStatus());
		response.setTipo(transacao.getTipo());
		response.setParcelas(transacao.getParcelas());

		return response;
	}

	public EstornoResponseDTO processarEstorno(String id) {
		Transacao transacao = transacoes.get(id);

		if (transacao == null) {
			throw new IllegalArgumentException("Transação não encontrada");
		}

		transacao.setStatus("CANCELADO");

		EstornoResponseDTO response = new EstornoResponseDTO();
		response.setId(transacao.getId());
		response.setCartao(transacao.getCartao());
		response.setValor(transacao.getValor());
		response.setDataHora(transacao.getDataHora());
		response.setEstabelecimento(transacao.getEstabelecimento());
		response.setNsu(transacao.getNsu());
		response.setCodigoAutorizacao(transacao.getCodigoAutorizacao());
		response.setStatus(transacao.getStatus());
		response.setTipo(transacao.getTipo());
		response.setParcelas(transacao.getParcelas());

		return response;
	}

	public PagamentoResponseDTO consultarPagamento(String id) {
		Transacao transacao = transacoes.get(id);

		if (transacao == null) {
			throw new IllegalArgumentException("Transação não encontrada");
		}

		PagamentoResponseDTO response = new PagamentoResponseDTO();
		response.setId(transacao.getId());
		response.setCartao(transacao.getCartao());
		response.setValor(transacao.getValor());
		response.setDataHora(transacao.getDataHora());
		response.setEstabelecimento(transacao.getEstabelecimento());
		response.setNsu(transacao.getNsu());
		response.setCodigoAutorizacao(transacao.getCodigoAutorizacao());
		response.setStatus(transacao.getStatus());
		response.setTipo(transacao.getTipo());
		response.setParcelas(transacao.getParcelas());

		return response;
	}

	public Map<String, Transacao> consultarTodos() {
		return transacoes;
	}
}