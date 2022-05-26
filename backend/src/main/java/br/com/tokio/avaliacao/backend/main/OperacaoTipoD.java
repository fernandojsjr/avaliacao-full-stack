package br.com.tokio.avaliacao.backend.main;

public class OperacaoTipoD implements CalculoTaxa {
	
	private Double valorTransferencia;
	
	private CalculoTaxa taxacao;

	public OperacaoTipoD(Double valorTransferencia, long qtdDias) {
		this.valorTransferencia = valorTransferencia;
		
		if(valorTransferencia <= 1_000.00d) {
			taxacao = new TaxacaoTipoA(this.valorTransferencia);			
		}else if((valorTransferencia > 1_000.00d) && (valorTransferencia <= 2_000.00d)) {
			taxacao = new TaxacaoTipoB(this.valorTransferencia);			
		}else if((valorTransferencia > 2_0001.00d)) {
			taxacao = new TaxacaoTipoC(this.valorTransferencia, qtdDias);			
		}
	}

	@Override
	public Double calcularValorTaxa() {
		return taxacao.calcularValorTaxa();
	}

}
