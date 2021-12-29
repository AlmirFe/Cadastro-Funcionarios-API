package br.com.almirjr.cadastrofuncionarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almirjr.cadastrofuncionarios.model.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long>{
	Funcionarios findById(long id);
	List<Funcionarios> findByNomeContains(String nome);

}
