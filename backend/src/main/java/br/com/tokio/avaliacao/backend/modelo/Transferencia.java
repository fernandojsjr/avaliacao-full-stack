package br.com.tokio.avaliacao.backend.modelo;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import br.com.tokio.avaliacao.backend.main.CalculoTaxa;

public class Transferencia {

	private String contaOrigem;
	private String contaDestino;
	private LocalDate dataAgendamento;
	private LocalDate dataTransferencia;
	private Double valorTransferencia = 0.0d;
	
	private CalculoTaxa taxa = null;
	
	private Transferencia(Builder builder) {
		this.contaOrigem = builder.getContaOrigem();
		this.contaDestino = builder.getContaDestino();
		this.dataAgendamento = LocalDate.now();
		this.dataTransferencia = builder.getDataTransferencia();
		this.valorTransferencia = builder.getValorTransferencia();
		this.taxa = null;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	protected void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	protected void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	protected void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	protected void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	protected void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public CalculoTaxa getTaxa() {
		return taxa;
	}

	protected void setTaxa(CalculoTaxa taxa) {
		this.taxa = taxa;
	}
	
	public long getQtdDias() {
		return DAYS.between(this.dataAgendamento, this.dataTransferencia);
	}

	public static class Builder {
		
		private String contaOrigem;
		private String contaDestino;
		private LocalDate dataAgendamento;
		private LocalDate dataTransferencia;
		private Double valorTransferencia = 0.0d;
		
		public Builder() {
		}
		
		public Transferencia build() {
			return new Transferencia(this);
		}

		protected String getContaOrigem() {
			return contaOrigem;
		}
		
		public Builder setContaOrigem(String contaOrigem) {
			this.contaOrigem = contaOrigem;
			return this;
		}
		
		public String getContaDestino() {
			return contaDestino;
		}
		
		public Builder setContaDestino(String contaDestino) {
			this.contaDestino = contaDestino;
			return this;
		}
		
		public LocalDate getDataAgendamento() {
			return dataAgendamento;
		}
		
		public LocalDate getDataTransferencia() {
			return dataTransferencia;
		}
		
		public Builder setDataTransferencia(LocalDate dataTransferencia) {
			this.dataTransferencia = dataTransferencia;
			return this;
		}
		
		public Double getValorTransferencia() {
			return valorTransferencia;
		}
		
		public Builder setValorTransferencia(Double valorTransferencia) {
			this.valorTransferencia = valorTransferencia;
			return this;
		}
		
		
	}
	
	
	
	
	
}
