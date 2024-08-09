package com.toolschallenge;

import com.toolschallenge.dto.PagamentoRequestDTO;
import com.toolschallenge.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToolsChallengeApplicationTests {

    @Autowired
    private TransacaoService transacaoService;

    @Test
    void testProcessarPagamento() {
        PagamentoRequestDTO request = new PagamentoRequestDTO();
        request.setCartao("4444********1234");
        request.setValor("500.50");
        request.setDataHora("01/05/2021 18:30:00");
        request.setEstabelecimento("PetShop Mundo cão");
        request.setTipo("AVISTA");
        request.setParcelas("1"); // Ajuste para String

        assertNotNull(transacaoService.processarPagamento(request));
    }

    @Test
    void testProcessarEstorno() {
        PagamentoRequestDTO request = new PagamentoRequestDTO();
        request.setCartao("4444********1234");
        request.setValor("500.50");
        request.setDataHora("01/05/2021 18:30:00");
        request.setEstabelecimento("PetShop Mundo cão");
        request.setTipo("AVISTA");
        request.setParcelas("1"); // Ajuste para String

        var pagamento = transacaoService.processarPagamento(request);
        var estorno = transacaoService.processarEstorno(pagamento.getId());

        assertEquals("CANCELADO", estorno.getStatus());
    }
}