package br.com.teste.teste.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.teste.teste.models.Empresa;
import br.com.teste.teste.repository.EmpresaRepository;

@RestController
@RequestMapping(value="/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@GetMapping("/list")
	public List<Empresa> listAll(){
		return empresaRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Empresa list(@PathVariable(value="id") long id ){
		return empresaRepository.findById(id);
	}
	
	@PostMapping("/create")
	public Empresa create(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	

}
