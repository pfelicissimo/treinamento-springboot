package br.com.opah.treinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.opah.treinamento.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
