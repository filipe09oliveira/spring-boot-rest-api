package br.com.teste.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.teste.teste.models.Conta;
import br.com.teste.teste.repository.ContaRepository;

@RestController
@RequestMapping(value="/conta")
public class ContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/list")
	public List<Conta> listAll(){
		return contaRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Conta list(@PathVariable(value="id") long id ){
		return contaRepository.findById(id);
	}
	
	@PostMapping("/create")
	public Conta create(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

}
