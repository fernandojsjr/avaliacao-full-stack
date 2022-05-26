package br.com.tokio.avaliacao.backend.main;

public class TaxacaoTipoB implements CalculoTaxa {
	
	private Double vlrTaxa = 12.00;
	private Double vlrTransferencia = 0.00;

	public TaxacaoTipoB(Double vlrTransferencia) {
		this.vlrTransferencia = vlrTransferencia;
	}

	@Override
	public Double calulaTaxa() {
		return vlrTransferencia + vlrTaxa;
	}

}
