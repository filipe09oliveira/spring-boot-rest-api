package br.com.teste.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.teste.teste.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{

	Movimentacao findById(long id);
	
}
