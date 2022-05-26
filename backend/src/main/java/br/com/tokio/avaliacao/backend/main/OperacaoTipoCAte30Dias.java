package br.com.tokio.avaliacao.backend.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperacaoTipoCAte30Dias implements CalculoTaxa {
	
	private Double pctTaxa = 1.047;
	private Double vlrTransferencia;

	public OperacaoTipoCAte30Dias(Double vlrTransferencia) {
		this.vlrTransferencia = vlrTransferencia;
	}

	@Override
	public Double calulaTaxa() {
		Double taxa = this.vlrTransferencia * this.pctTaxa;
		return BigDecimal.valueOf(taxa).setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
