package br.com.teste.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.teste.teste.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findById(long id);
	
}
