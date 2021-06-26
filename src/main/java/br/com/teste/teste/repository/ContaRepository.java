package br.com.teste.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.teste.teste.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	Conta findById(long id);
	
}
