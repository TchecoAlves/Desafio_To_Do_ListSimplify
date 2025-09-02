package dev.cleisonalves.springboot_desafio_todo_list.service;

import dev.cleisonalves.springboot_desafio_todo_list.model.TodoModel;
import dev.cleisonalves.springboot_desafio_todo_list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Criar
    public TodoModel criar(TodoModel todoModel){
        return todoRepository.save(todoModel);
    }

    //Listar
    public List<TodoModel> listar(TodoModel todoModel){
        return todoRepository.findAll();
    }

    //Atualizar
    public TodoModel atualizar(Long id, TodoModel listaAtualizada){
        if (todoRepository.existsById(id)){
            listaAtualizada.setId(id);
            return todoRepository.save(listaAtualizada);
        }
        return null;
    }

    //Deletar tem que ser void
    public void deletar(Long id){
         todoRepository.deleteById(id);
    }
}
