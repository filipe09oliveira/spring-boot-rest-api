package br.com.teste.teste.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.teste.teste.models.Movimentacao;
import br.com.teste.teste.repository.MovimentacaoRepository;

@RestController
@RequestMapping(value="/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	@GetMapping("/list")
	public List<Movimentacao> listAll(){
		return movimentacaoRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Movimentacao list(@PathVariable(value="id") long id ){
		return movimentacaoRepository.findById(id);
	}
	
	@PostMapping("/create")
	public Movimentacao create(@RequestBody Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}
		

}
