package br.com.tokio.avaliacao.backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TransferenciaTest {

	@Test
	void testBuilder() {
		
		String contaOrigem = "000001";
		String contaDestino = "000002";
		LocalDate dataAgend = LocalDate.now();
		LocalDate dataTransf = dataAgend.plusDays(15);
		Double valor = 250.45d;
		Long qtdDias = 15l;
		
		
		Transferencia t = new Transferencia.Builder()
				.setContaOrigem(contaOrigem)
				.setContaDestino(contaDestino)
				.setDataTransferencia(dataTransf) // 04/06
				.setVlrTransferencia(250.45d)
				.build();
		
		assertEquals(contaOrigem, t.getContaOrigem());
		assertEquals(contaDestino, t.getContaDestino());
		assertEquals(dataAgend, t.getDataAgendamento());
		assertEquals(dataTransf, t.getDataTransferencia());
		assertEquals(valor, t.getVlrTransferencia());
		assertEquals(qtdDias, t.getQtdDias());
		
		
		System.out.println(String.format("Conta Origem: %s \nConta Destino: %s, \nData.Agendamento: %s\nData.Transf: %s,\nValor: %s\nQtd.Dias: %s", 
				t.getContaOrigem(), t.getContaDestino(), t.getDataAgendamento(), t.getDataTransferencia(), t.getVlrTransferencia(), t.getQtdDias()));
	}

}
