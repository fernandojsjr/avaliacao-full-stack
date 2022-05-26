package br.com.tokio.avaliacao.backend.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;

import br.com.tokio.avaliacao.backend.main.TaxacaoTipoA;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoB;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoC;

class TransferenciaTest {
	
	@Test
	void testTransferenciaBuilder() {
		
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
		
		Double valorTaxa = 106.00;
		
		Transferencia transf = new Transferencia.Builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(LocalDate.now())
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}
	
	@Test
	void TransferenciaAte10Dias() {
		
		Double valorTaxa = 112.00;
		
		Transferencia transf = new Transferencia.Builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(LocalDate.now().plusDays(10))
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}
	
	@Test
	void TransferenciaAcimaDe10Dias() {
		
		Double valorTaxa = 108.20;
		
		Transferencia transf = new Transferencia.Builder()
				.setContaOrigem("000001")
				.setContaDestino("000002")
				.setDataTransferencia(LocalDate.now().plusDays(12))
				.setValorTransferencia(100.00d)
				.build();
		
		assertEquals(valorTaxa, transf.getValorTaxa());
	}	

}
