package br.com.tokio.avaliacao.backend.factory;

import br.com.tokio.avaliacao.backend.main.CalculoTaxa;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoA;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoB;
import br.com.tokio.avaliacao.backend.main.TaxacaoTipoC;
import br.com.tokio.avaliacao.backend.modelo.Transferencia;

public class TaxaFactory implements CalculoTaxa {

	private Transferencia transferencia;

	public TaxaFactory(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
	
	@Override
	public Double calcularValorTaxa() {
		
		CalculoTaxa retorno = null;
		
		long qtdDias = this.transferencia.getQtdDias();
		
		if(qtdDias <= 0) {
			retorno = new TaxacaoTipoA(transferencia.getValorTransferencia());
		}else if(qtdDias <= 10) {
			retorno = new TaxacaoTipoB(transferencia.getValorTransferencia());
		}else if(qtdDias > 10 ) {
			retorno = new TaxacaoTipoC(transferencia.getValorTransferencia(), qtdDias);
		}
		
		return retorno.calcularValorTaxa();
	}
	
}
