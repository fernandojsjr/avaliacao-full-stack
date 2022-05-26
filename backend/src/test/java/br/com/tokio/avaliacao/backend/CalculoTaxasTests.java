package br.com.tokio.avaliacao.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tokio.avaliacao.backend.main.CalculoTaxa;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoC;
import br.com.tokio.avaliacao.backend.main.OperacaoTipoCAte20Dias;
import br.com.tokio.avaliacao.backend.main.OperacaoTipoCAte30Dias;
import br.com.tokio.avaliacao.backend.main.OperacaoTipoCAte40Dias;
import br.com.tokio.avaliacao.backend.main.OperacaoTipoD;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoB;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoA;

@SpringBootTest
class CalculoTaxasTests {

	@Test
	void transferenciaNoMesmoDia() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoA(valorTransferencia);
		
		assertEquals(106.0, taxa.calulaTaxa());
		
	}
	
	@Test
	void transferenciaComAte10Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoB(valorTransferencia);
		
		assertEquals(112.00, taxa.calulaTaxa());
		
	}
	
	@Test
	void transferenciaTipoCAcimaDe10Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new TaxacaoTipoC(valorTransferencia);
		
		assertEquals(108.20, taxa.calulaTaxa());
	}
	
	@Test
	void transferenciaTipoCAcimaDe20Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new OperacaoTipoCAte20Dias(valorTransferencia);
		
		assertEquals(106.90, taxa.calulaTaxa());
	}
	
	@Test
	void transferenciaTipoCAcimaDe30Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new OperacaoTipoCAte30Dias(valorTransferencia);
		
		assertEquals(104.70, taxa.calulaTaxa());
	}		
	
	@Test
	void transferenciaTipoCAcimaDe40Dias() {
		
		Double valorTransferencia = 100.0;
		
		CalculoTaxa taxa = new OperacaoTipoCAte40Dias(valorTransferencia);
		
		assertEquals(101.70, taxa.calulaTaxa());
	}
	
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

	

}
