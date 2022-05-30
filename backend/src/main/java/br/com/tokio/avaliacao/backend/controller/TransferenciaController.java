package br.com.tokio.avaliacao.backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokio.avaliacao.backend.dto.TransferenciaDTO;
import br.com.tokio.avaliacao.backend.modelo.Transferencia;
import br.com.tokio.avaliacao.backend.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private final TransferenciaService service;
	
	public TransferenciaController(TransferenciaService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Transferencia>> listAll(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Transferencia> getById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Transferencia> create(@RequestBody @Valid TransferenciaDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Transferencia> update(@PathVariable Long id, @RequestBody @Valid TransferenciaDTO dto){
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Transferencia> delete(@PathVariable Long id){
		return ResponseEntity.ok(service.delete(id));
	}
	
}
