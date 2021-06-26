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
import br.com.teste.teste.repository.ClienteRepository;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
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
		return clienteRepository.save(cliente);
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
