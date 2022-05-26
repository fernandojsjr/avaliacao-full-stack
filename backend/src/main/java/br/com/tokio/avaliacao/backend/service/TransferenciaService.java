package br.com.tokio.avaliacao.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokio.avaliacao.backend.dto.TransferenciaDTO;
import br.com.tokio.avaliacao.backend.factory.TaxaFactory;
import br.com.tokio.avaliacao.backend.modelo.Transferencia;
import br.com.tokio.avaliacao.backend.repository.TransferenciaRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransferenciaService {
	
	@Autowired
	private final TransferenciaRepository repository;
	
	public TransferenciaService(TransferenciaRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<Transferencia> listAll(){
		return repository.findAll();
	}
	
	public Transferencia getById(Long id) {
		return repository.findById(id).orElseThrow(() -> {
			log.error("Transferencia não encontrada, id: {}",id);
			return new RuntimeException("Transferencia não encontrada, id: " + id);
		}); 
	}
	
	public Transferencia create(TransferenciaDTO dto) {
		
		Transferencia transf = new Transferencia.Builder()
				.setContaOrigem(dto.getContaOrigem())
				.setContaDestino(dto.getContaDestino())
				.setDataTransferencia(dto.getDataTransferencia())
				.setValorTransferencia(dto.getValorTransferencia())
				.build();
		
		return repository.save(transf);
	}
	
	public Transferencia delete(Long id) {
		
		Transferencia transf = repository.findById(id).orElseThrow(() -> {
			log.error("Transferencia não encontrada, id: {}",id);
			return new RuntimeException("Transferencia não encontrada, id: " + id);
		}); 
		repository.delete(transf);
		return transf;
		
	}
	
	public Transferencia update(Long id, TransferenciaDTO dto) {

		Transferencia transf =  repository.findById(id).orElseThrow( () -> {
			log.error("Transferencia não encontrada, id: {}");
			return new RuntimeException("ransferencia não encontrada, id: " + id);
		});
		
		transf.setContaOrigem(dto.getContaOrigem());
		transf.setContaDestino(dto.getContaDestino());
		transf.setDataTransferencia(dto.getDataTransferencia());
		transf.setValorTransferencia(dto.getValorTransferencia());
		transf.setValorTaxa(new TaxaFactory(transf).calcularValorTaxa());
		
		return repository.save(transf);
	}
	

}
