package br.com.tokio.avaliacao.backend.main;

public class TaxacaoTipoA implements CalculoTaxa {
	
	/*
	 * Calculo de Taxas para transferencias no mesmo dia
	 */
	
	private Double valorTaxa = 3.0;
	private Double pctTaxa = 0.03;
	private Double vlrTransferencia = 0.0;
	
	public TaxacaoTipoA(Double valorTransferencia) {
		this.vlrTransferencia = valorTransferencia;
	}


	@Override
	public Double calcularValorTaxa() {
		return (vlrTransferencia * pctTaxa) + valorTaxa;
	}

}