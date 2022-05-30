package br.com.tokio.avaliacao.backend.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TransferenciaTest {
		
	@Test
	void testTransferenciaBuilder() {
		
		String contaOrigem = "000001";
		String contaDestino = "000002";
		Date dataAgend = new Date();
		//LocalDate dataTransf = dataAgend.plusDays(15);
		Date dataTransf = Date.from(Instant.now().plus(15, ChronoUnit.DAYS));
		Double valor = 250.45d;
		Long qtdDias = 15l;
		
		Transferencia t = Transferencia.builder()
				.setContaOrigem(contaOrigem)
				.setContaDestino(contaDestino)
				.setDataTransferencia(dataTransf) // 04/06
				.setValorTransferencia(250.45d)
				.build();
		
		assertEquals(contaOrigem, t.getContaOrigem());
		assertEquals(contaDestino, t.getContaDestino());
		assertEquals(dataAgend, t.getDataAgendamento());
		assertEquals(dataTransf, t.getDataTransferencia());
		assertEquals(valor, t.getValorTransferencia());
		assertEquals(qtdDias, t.getQtdDias());
		
		
		System.out.println(String.format("Conta Origem: %s \nConta Destino: %s, \nData.Agendamento: %s\nData.Transf: %s,\nValor: %s\nQtd.Dias: %s", 
				t.getContaOrigem(), t.getContaDestino(), t.getDataAgendamento(), t.getDataTransferencia(), t.getValorTransferencia(), t.getQtdDias()));
	}	

	@Test
	void TransferenciaMesmoDia() {
		
		Double valorTaxa = 6.00;
		
		Transferencia transf = Transferencia.builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(new Date())
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}
	
	@Test
	void TransferenciaAte10Dias() {
		
		Double valorTaxa = 112.00;
		Date dtaTransf = Date.from(Instant.now().plus(10, ChronoUnit.DAYS));
		
		Transferencia transf = Transferencia.builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(dtaTransf)
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}
	
	@Test
	void TransferenciaAcimaDe10Dias() {
		
		Double valorTaxa = 8.21;
		
		Date dtaTransf  = Date.from(Instant.now().plus(15, ChronoUnit.DAYS));
		
		Transferencia transf = Transferencia.builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(dtaTransf)
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}	

}
