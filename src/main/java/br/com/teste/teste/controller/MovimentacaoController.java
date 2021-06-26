package br.com.teste.teste.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.teste.models.Cliente;
import br.com.teste.teste.models.Conta;
import br.com.teste.teste.models.Movimentacao;
import br.com.teste.teste.repository.ClienteRepository;
import br.com.teste.teste.repository.ContaRepository;
import br.com.teste.teste.repository.MovimentacaoRepository;

@RestController
@RequestMapping(value="/movimentacao")
public class MovimentacaoController {
	
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/list")
	public List<Movimentacao> listAll(){
		return movimentacaoRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Movimentacao list(@PathVariable(value="id") long id ){
		return movimentacaoRepository.findById(id);
	}
	
	@PostMapping("/create/{cliente_id}/{conta_id}")
	public Movimentacao create(@RequestBody Movimentacao movimentacao, @PathVariable(value="cliente_id") long cliente_id, @PathVariable(value="conta_id") long conta_id) {
		movimentacaoRepository.save(movimentacao);
		
		Cliente cliente = clienteRepository.findById(cliente_id);
		Conta conta = contaRepository.findById(conta_id);		
		movimentacao.setCliente(cliente);
		movimentacao.setConta(conta);
		
		double valorConta = conta.getValor();
		double valorMovimentacao = movimentacao.getValor();
		double resultado = valorConta - valorMovimentacao;
		
		conta.setValor(resultado);
		
		contaRepository.save(conta);
			
		return movimentacao;
	}
		

}
