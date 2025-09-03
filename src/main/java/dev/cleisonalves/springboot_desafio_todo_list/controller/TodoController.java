package dev.cleisonalves.springboot_desafio_todo_list.controller;

import dev.cleisonalves.springboot_desafio_todo_list.model.TodoModel;
import dev.cleisonalves.springboot_desafio_todo_list.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //Criar
    @PostMapping
    public TodoModel criar(@RequestBody TodoModel todoModel){
        return todoService.criar(todoModel);
    }

    //Listar
    @GetMapping
    public List<TodoModel> listar(TodoModel todoModel){
        return todoService.listar(todoModel);
    }

    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<TodoModel> atualizar(@PathVariable Long id, @RequestBody TodoModel listaAtualizada){
        TodoModel atualizado = todoService.atualizar(id, listaAtualizada);
        if (atualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
         todoService.deletar(id);
         return ResponseEntity.noContent().build();
    }

}
