package br.com.tokio.avaliacao.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tokio.avaliacao.backend.main.CalculoTaxa;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoA;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoB;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoC;
import br.com.tokio.avaliacao.backend.modelo.Transferencia;

@SpringBootTest
class CalculoTaxasTests {
	
	@Test
	void testMain() {
		
		
		Instant d2 = Instant.now();
		Instant.now().plus(1, ChronoUnit.DAYS);
		
		Transferencia t = new Transferencia.Builder()
				.setContaOrigem("001")
				.setContaDestino("002")
				//.setDataTransferencia(LocalDate.now().plusDays(15)) // 04/06
				.setDataTransferencia(Date.from(Instant.now().plus(15, ChronoUnit.DAYS)))
				.setValorTransferencia(250.45d)
				.build();
		
		System.out.println(String.format("Conta Origem: %s \nConta Destino: %s, \nData.Agendamento: %s\nData.Transf: %s,\nValor: %s\nQtd.Dias: %s", 
				t.getContaOrigem(), t.getContaDestino(), t.getDataAgendamento(), t.getDataTransferencia(), t.getValorTransferencia(), t.getQtdDias()));
	}

	@Test
	void transferenciaNoMesmoDia() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoA(valorTransferencia);
		
		assertEquals(6.0, taxa.calcularValorTaxa());
		
	}
	
	@Test
	void transferenciaComAte10Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoB(valorTransferencia);
		
		assertEquals(112.00, taxa.calcularValorTaxa());
		
	}
	
	@Test
	void transferenciaTipoCAcimaDe10Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoC(valorTransferencia, 11l);
		
		assertEquals(8.21, taxa.calcularValorTaxa());
	}
	
	@Test
	void transferenciaTipoCAcimaDe20Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoC(valorTransferencia, 21l);
		
		assertEquals(6.90, taxa.calcularValorTaxa());
	}
	
	@Test
	void transferenciaTipoCAcimaDe30Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoC(valorTransferencia, 31l);
		
		assertEquals(4.70, taxa.calcularValorTaxa());		

	}		
	
	@Test
	void transferenciaTipoCAcimaDe40Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoC(valorTransferencia, 41l);
		
		assertEquals(1.71, taxa.calcularValorTaxa());
	}
	
	/*
	@Test
	void TaxacaoTipoDTipoA() {
		Double valorTransferencia = 1_000.00d;
		
		CalculoTaxa taxa = new OperacaoTipoD(valorTransferencia);
		
		assertEquals(1_033.00, taxa.calulaTaxa());
		
	}
	
	@Test
	void TaxacaoTipoDTipoB() {
		Double valorTransferencia = 1_001.00d;
		
		CalculoTaxa taxa = new OperacaoTipoD(valorTransferencia);
		
		assertEquals(1_013.00, taxa.calulaTaxa());		
	}	
	
	@Test
	void TaxacaoTipoDTipoC() {
		Double valorTransferencia = 2_001.00d;
		
		CalculoTaxa taxa = new OperacaoTipoD(valorTransferencia);
		
		assertEquals(2_165.09, taxa.calulaTaxa());		
		
	}	
*/
	

}
