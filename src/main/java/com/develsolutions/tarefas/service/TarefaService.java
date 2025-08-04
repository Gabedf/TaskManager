package com.develsolutions.tarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.develsolutions.tarefas.model.Tarefa;

@Service
public class TarefaService {
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Long proximoId = 1L;

    public void mostrarTarefas() {
        for (Tarefa tarefa : this.listaTarefas) {
            System.out.println(tarefa);
        }
    }

    public List<Tarefa> listarTarefas() {
        return this.listaTarefas;
    }

    public Tarefa criarTarefa(String titulo) {
        Tarefa t = new Tarefa(proximoId++, titulo);
        listaTarefas.add(t);
        return t;
    }

    public Optional<Tarefa> atualizar(Long id, String novoTitulo, boolean concluida) {
        for (Tarefa tarefa : this.listaTarefas) {
            if (id.equals(tarefa.getId())) {
                tarefa.setConcluida(concluida);
                tarefa.setTitulo(novoTitulo);
                return Optional.of(tarefa);
            }
        }
        return Optional.empty();
    }

    public boolean deletar(Long id) {
        for (Tarefa tarefa : this.listaTarefas) {
            if (id.equals(tarefa.getId())) { 
                this.listaTarefas.remove(tarefa); 
                return true;
                }   
        }
        return false;
    }
}
