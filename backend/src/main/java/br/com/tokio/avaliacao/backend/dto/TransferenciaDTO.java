package br.com.tokio.avaliacao.backend.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferenciaDTO {

	@NotEmpty(message = "Conta Origem requerida")
	private String contaOrigem;
	
	@NotEmpty(message = "Conta Destino requerida")
	private String contaDestino;
	
	@NotEmpty(message = "Data de Agendamento requerida")
	private LocalDate dataTransferencia;
	
	@NotEmpty(message = "Valor de Transferencia requerida")
	private Double valorTransferencia;
}
