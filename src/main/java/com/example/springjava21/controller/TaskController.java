package com.example.springjava21.controller;

import com.example.springjava21.dto.Task;
import com.example.springjava21.service.TaskService;
import com.example.springjava21.utils.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/api/task")
    public ResponseEntity<Task> createTask(@RequestBody  Task taskRequest){
        Function<Task, Task> createTaskFunction = taskService.createTask();
        return ResponseEntity.ok(createTaskFunction.apply(taskRequest));
    }

    @GetMapping("/api/tasks/{taskId}")
    public ResponseEntity<Task> findTask(@PathVariable Integer taskId){
        Function<Integer, Task> findTaskFunction = taskService.getTaskById();
        return ResponseEntity.ok(findTaskFunction.apply(taskId));
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> findAllTasks(){
        Function<Unit, List<Task>> findTasksFunction = taskService.getTasks();
        return ResponseEntity.ok(findTasksFunction.apply(Unit.unit()));
    }
}
