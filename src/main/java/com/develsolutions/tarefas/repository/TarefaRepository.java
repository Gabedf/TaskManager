package com.develsolutions.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develsolutions.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
