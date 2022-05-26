package br.com.tokio.avaliacao.backend.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperacaoTipoCAte20Dias implements CalculoTaxa {

	private Double pctTaxa = 1.069;
	private Double vlrTransferencia;

	public OperacaoTipoCAte20Dias(Double vlrTransferencia) {
		this.vlrTransferencia = vlrTransferencia;
		
	}	
	
	@Override
	public Double calulaTaxa() {
		Double taxa = this.vlrTransferencia * this.pctTaxa;
		return BigDecimal.valueOf(taxa).setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
