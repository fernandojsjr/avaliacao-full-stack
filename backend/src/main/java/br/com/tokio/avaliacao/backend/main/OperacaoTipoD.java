package br.com.tokio.avaliacao.backend.main;

public class OperacaoTipoD implements CalculoTaxa {
	
	private Double vlrTransferencia;
	
	private CalculoTaxa taxacao;

	public OperacaoTipoD(Double vlrTransferencia) {
		this.vlrTransferencia = vlrTransferencia;
		
		if(vlrTransferencia <= 1_000.00d) {
			taxacao = new TaxacaoTipoA(this.vlrTransferencia);			
		}else if((vlrTransferencia > 1_000.00d) && (vlrTransferencia <= 2_000.00d)) {
			taxacao = new TaxacaoTipoB(this.vlrTransferencia);			
		}else if((vlrTransferencia > 2_000.00d)) {
			taxacao = new TaxacaoTipoC(this.vlrTransferencia);			
		}
	}

	@Override
	public Double calulaTaxa() {
		return taxacao.calulaTaxa();
	}

}
