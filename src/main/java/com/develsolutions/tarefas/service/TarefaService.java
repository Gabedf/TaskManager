package com.develsolutions.tarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.develsolutions.tarefas.model.Tarefa;
import com.develsolutions.tarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    private final TarefaRepository tarefasRepository;

    public TarefaService(TarefaRepository tarefasRepository) { this.tarefasRepository = tarefasRepository; }

    public List<Tarefa> listarTarefas() {
        return this.tarefasRepository.findAll();
    }

    public Tarefa criarTarefa(String titulo) {
        Tarefa t = new Tarefa(titulo);
        return tarefasRepository.save(t);
    }

    public Optional<Tarefa> atualizar(Long id, String novoTitulo, boolean concluida) {
        Optional<Tarefa> tarefaOpt = tarefasRepository.findById(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefa = tarefaOpt.get();
            tarefa.setTitulo(novoTitulo);
            tarefa.setConcluida(concluida);
            return Optional.of(tarefasRepository.save(tarefa));
        }
        return Optional.empty();
            }

    public boolean deletar(Long id) {
        if (this.tarefasRepository.existsById(id)) {
            this.tarefasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
