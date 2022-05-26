package br.com.tokio.avaliacao.backend.main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.math3.util.Precision;

public class TaxacaoTipoC implements CalculoTaxa {
	
	private Double pctTaxa;
	private Double valorTransferencia;

	public TaxacaoTipoC(Double valorTransferencia, long qtdDias) {
		
		this.valorTransferencia = valorTransferencia;
		
		if(qtdDias > 10 && qtdDias <= 20 ) {
			this.pctTaxa = 1.082;			
		}else if(qtdDias > 20 && qtdDias <= 30 ) {
			this.pctTaxa = 1.069;
		}else if(qtdDias > 30 && qtdDias <= 40) {
			this.pctTaxa = 1.047;
		}else this.pctTaxa = 1.017;
	}

	@Override
	public Double calulaTaxa() {
		Double taxa = this.valorTransferencia * this.pctTaxa;
		return BigDecimal.valueOf(taxa).setScale(2, RoundingMode.CEILING).doubleValue();
	}

}
