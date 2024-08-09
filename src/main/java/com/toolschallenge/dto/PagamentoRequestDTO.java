package com.toolschallenge.dto;

public class PagamentoRequestDTO {
	private String cartao;
	private String valor;
	private String dataHora;
	private String estabelecimento;
	private String tipo;
	private String parcelas; // Ajuste para String

	// Getters e Setters

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}
}