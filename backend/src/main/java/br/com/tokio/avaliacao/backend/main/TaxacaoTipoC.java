package br.com.tokio.avaliacao.backend.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.math3.util.Precision;

public class TaxacaoTipoC implements CalculoTaxa {
	
	private Double pctTaxa = 1.082;
	private Double vlrTransferencia;

	public TaxacaoTipoC(Double vlrTransferencia) {
		this.vlrTransferencia = vlrTransferencia;
		
	}

	@Override
	public Double calulaTaxa() {
		Double taxa = this.vlrTransferencia * this.pctTaxa;
		return BigDecimal.valueOf(taxa).setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
