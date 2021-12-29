package br.com.almirjr.cadastrofuncionarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.almirjr.cadastrofuncionarios.model.Funcionarios;
import br.com.almirjr.cadastrofuncionarios.repository.FuncionariosRepository;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncionariosController {
	
	@Autowired
	private FuncionariosRepository funcionariosRepository;
	
	@GetMapping("/list")
	public List<Funcionarios> listaFuncionarios(){
		return funcionariosRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Funcionarios buscaFuncionario(@PathVariable(value="id") long id){
		return funcionariosRepository.findById(id);
	}
	
	@GetMapping("/filter")
	public List<Funcionarios> filtraFuncionario(@RequestParam String nome){
		return funcionariosRepository.findByNomeContains(nome); 
	}
	@PostMapping("/add")
	public Funcionarios addFuncionario(@RequestBody Funcionarios funcionario) {
		return funcionariosRepository.save(funcionario); 
		
	}
	

}
