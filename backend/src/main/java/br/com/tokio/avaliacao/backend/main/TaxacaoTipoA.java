package br.com.tokio.avaliacao.backend.main;

public class TaxacaoTipoA implements CalculoTaxa {
	
	private Double valorTaxa = 3.0;
	private Double pctTaxa = 1.03;
	private Double vlrTransferencia = 0.0;
	
	public TaxacaoTipoA(Double valorTransferencia) {
		this.vlrTransferencia = valorTransferencia;
	}

	@Override
	public Double calulaTaxa() {
		return (vlrTransferencia * pctTaxa) + valorTaxa;
	}

}
