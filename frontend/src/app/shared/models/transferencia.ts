export interface Transferencia {
  id?: number,
  contaOrigem?: string,
  contaDestino?: string,
  dataAgendamento: Date,
  dataTransferencia?: Date,
  valorTransferencia?: number,
  valorTaxa?: number,
  qtdDias?: number
}