package br.com.teste.teste.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ContaRepository contaRepository;
	@Autowired
	MovimentacaoRepository movimentacaoRepository;
	
	@GetMapping("/list")
	public List<Cliente> listAll(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Cliente list(@PathVariable(value="id") long id ){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/create")
	public Cliente create(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		
		//Primeira Conta
		Conta conta = new Conta();
		conta.setAgencia("0001");
		conta.setConta("73218581-7");
		conta.setBanco("Nu Pagamentos S.A.");
		conta.setValor(2500.00);
		conta.setCliente(cliente);
		contaRepository.save(conta);
		
		//Movimentação Incial
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setCliente(cliente);
		movimentacao.setConta(conta);
		movimentacao.getData();
		movimentacao.setValor(500);
		
		double valorConta = conta.getValor();
		double valorMovimentacao = movimentacao.getValor();
		
		if (valorConta < valorMovimentacao) {
			System.out.println("Não pode movimentar o valor" + valorMovimentacao);
		} else {
			double resultado = valorConta - valorMovimentacao;
			conta.setValor(resultado);
			contaRepository.save(conta);
		}
		
		contaRepository.save(conta);
		movimentacaoRepository.save(movimentacao);
		
		return cliente;
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/update")
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
