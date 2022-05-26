package br.com.tokio.avaliacao.backend.main;

public class TaxacaoTipoB implements CalculoTaxa {
	
	/*
	 * Taxação para transferencias feitas até 10 dias
	 */
	
	private Double valorTaxa = 12.00;
	private Double valorTransferencia = 0.00;

	public TaxacaoTipoB(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	@Override
	public Double calulaTaxa() {
		return valorTransferencia + valorTaxa;
	}

}
