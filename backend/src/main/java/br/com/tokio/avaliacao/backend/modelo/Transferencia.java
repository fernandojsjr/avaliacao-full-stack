package br.com.tokio.avaliacao.backend.modelo;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import br.com.tokio.avaliacao.backend.dto.TransferenciaDTO.TransferenciaDTOBuilder;
import br.com.tokio.avaliacao.backend.factory.TaxaFactory;

@Entity
@Table(name = "transferencia")
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Conta Origem requerida")
	private String contaOrigem;
	
	@NotEmpty(message = "Conta Destino requerida")
	private String contaDestino;
	
	//@NotEmpty(message = "Data de Agendamento requerida")
	private LocalDate dataAgendamento;
	
	//@NotEmpty(message = "Data de Transferencia requerida")
	private LocalDate dataTransferencia;
	
	//@NotEmpty(message = "Valor de Transferencia requerida")
	private Double valorTransferencia;
	
	private Double valorTaxa;
	
	protected Transferencia() {
		
	}
	
	private Transferencia(Builder builder) {
		this.contaOrigem = builder.getContaOrigem();
		this.contaDestino = builder.getContaDestino();
		this.dataAgendamento = LocalDate.now();
		this.dataTransferencia = builder.getDataTransferencia();
		this.valorTransferencia = builder.getValorTransferencia();
		this.setValorTaxa(new TaxaFactory(this).calcularValorTaxa());
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public void updateVlrTaxa(Double calcularValorTaxa) {
		this.setValorTaxa(calcularValorTaxa);
	}	

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	
	public Double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(Double valorTaxa) {
		this.valorTaxa = valorTaxa;
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
