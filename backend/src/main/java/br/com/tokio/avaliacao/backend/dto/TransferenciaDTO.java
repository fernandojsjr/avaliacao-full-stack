package br.com.tokio.avaliacao.backend.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferenciaDTO {

	@NotEmpty(message = "Conta Origem requerida")
	private String contaOrigem;
	
	@NotEmpty(message = "Conta Destino requerida")
	private String contaDestino;
	
	//@NotNull(message = "Data de Agendamento requerida")
	private LocalDate dataTransferencia;
	
	//@NotNull(message = "Valor de Transferencia requerida")
	private Double valorTransferencia;
}
