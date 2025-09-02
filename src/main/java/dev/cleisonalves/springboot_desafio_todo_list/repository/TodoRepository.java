package dev.cleisonalves.springboot_desafio_todo_list.repository;

import dev.cleisonalves.springboot_desafio_todo_list.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {
}
