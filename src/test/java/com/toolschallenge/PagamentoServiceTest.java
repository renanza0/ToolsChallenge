package com.toolschallenge;

import com.toolschallenge.dto.EstornoResponseDTO;
import com.toolschallenge.dto.PagamentoRequestDTO;
import com.toolschallenge.dto.PagamentoResponseDTO;
import com.toolschallenge.model.Transacao;
import com.toolschallenge.service.TransacaoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoServiceTest {

    @Test
    public void deveRealizarPagamentoComSucesso() {
        TransacaoService service = new TransacaoService();
        PagamentoRequestDTO request = new PagamentoRequestDTO();
        request.setCartao("4444********1234");
        request.setValor("500.50");
        request.setDataHora("01/05/2021 18:30:00");
        request.setEstabelecimento("PetShop Mundo cão");
        request.setTipo("AVISTA");
        request.setParcelas("1");

        PagamentoResponseDTO resultado = service.processarPagamento(request);

        assertNotNull(resultado);
        assertEquals("4444********1234", resultado.getCartao());
        assertEquals("500.50", resultado.getValor());
        assertEquals("01/05/2021 18:30:00", resultado.getDataHora());
        assertEquals("PetShop Mundo cão", resultado.getEstabelecimento());
        assertEquals("1234567890", resultado.getNsu());
        assertEquals("147258369", resultado.getCodigoAutorizacao());
        assertEquals("AUTORIZADO", resultado.getStatus());
        assertEquals("AVISTA", resultado.getTipo());
        assertEquals("1", resultado.getParcelas());
    }

    @Test
    public void deveEstornarPagamentoComSucesso() {
        TransacaoService service = new TransacaoService();
        PagamentoRequestDTO request = new PagamentoRequestDTO();
        request.setCartao("4444********1234");
        request.setValor("500.50");
        request.setDataHora("01/05/2021 18:30:00");
        request.setEstabelecimento("PetShop Mundo cão");
        request.setTipo("AVISTA");
        request.setParcelas("1");

        // Primeiro realiza o pagamento
        PagamentoResponseDTO pagamento = service.processarPagamento(request);

        // Realiza o estorno
        EstornoResponseDTO estorno = service.processarEstorno(pagamento.getId());

        assertNotNull(estorno);
        assertEquals(pagamento.getId(), estorno.getId());
        assertEquals("4444********1234", estorno.getCartao());
        assertEquals("500.50", estorno.getValor());
        assertEquals("01/05/2021 18:30:00", estorno.getDataHora());
        assertEquals("PetShop Mundo cão", estorno.getEstabelecimento());
        assertEquals("1234567890", estorno.getNsu());
        assertEquals("147258369", estorno.getCodigoAutorizacao());
        assertEquals("CANCELADO", estorno.getStatus());
        assertEquals("AVISTA", estorno.getTipo());
        assertEquals("1", estorno.getParcelas());
    }
}