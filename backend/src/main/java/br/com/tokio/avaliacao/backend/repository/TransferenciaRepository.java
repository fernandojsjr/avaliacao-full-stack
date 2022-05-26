package br.com.tokio.avaliacao.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tokio.avaliacao.backend.modelo.Transferencia;

@Repository
public interface TransferenciaRepository extends CrudRepository<Transferencia, Long> {

}
