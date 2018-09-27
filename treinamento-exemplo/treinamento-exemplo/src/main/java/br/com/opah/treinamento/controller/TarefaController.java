package br.com.opah.treinamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opah.treinamento.exceptions.NotFoundException;
import br.com.opah.treinamento.model.Tarefa;
import br.com.opah.treinamento.model.vo.TarefaVo;
import br.com.opah.treinamento.repositories.TarefaRepository;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaRepository _repository;

	
	@GetMapping(path ="")
	public List<Tarefa> check() {
		return _repository.findAll();
	}
	
	@GetMapping(path ="/mapped")
	public List<TarefaVo> map() {
		return _repository.findAll().stream().map(tarefa -> {
			
			TarefaVo vo = new TarefaVo();
			vo.setDescricao(tarefa.getDescricao());
			vo.setId(tarefa.getId());
			
			return vo;
			
		}).collect(Collectors.toList());
	}
	
	@PostMapping
	public Tarefa add(@RequestBody Tarefa tarefa) {
		return _repository.save(tarefa);
	}
	
	@PutMapping("/{id}")
	public Tarefa update(@PathVariable Long id, @RequestBody Tarefa newTarefa) throws Exception {
		
		return _repository.findById(id)
							.map(tarefa -> {
								tarefa.setConcluida(newTarefa.getConcluida());
								tarefa.setDataConclusao(newTarefa.getDataConclusao());
								tarefa.setDescricao(newTarefa.getDescricao());
								
								return _repository.save(tarefa);
								
							}).orElseThrow(() -> new NotFoundException(String.format("Tarefa %d não encontrada", id)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		
		
		return _repository.findById(id)
                .map(answer -> {
                	_repository.delete(answer);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new NotFoundException(String.format("Tarefa %d não encontrada", id)));

			
	}
	
	
}
