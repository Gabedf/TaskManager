package com.develsolutions.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develsolutions.tarefas.model.Tarefa;
import com.develsolutions.tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return tarefaService.listarTarefas();
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody String titulo) {
        return tarefaService.criarTarefa(titulo);
    }

    @PutMapping("/{id}")
    public Optional<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa dados) {
        return tarefaService.atualizar(id, dados.getTitulo(), dados.isConcluida());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }
}
