package com.oliveiradev.todo_api.repository;

import com.oliveiradev.todo_api.domain.Task;
import com.oliveiradev.todo_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}
