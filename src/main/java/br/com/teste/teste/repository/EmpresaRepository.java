package br.com.teste.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.teste.teste.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findById(long id);

}
