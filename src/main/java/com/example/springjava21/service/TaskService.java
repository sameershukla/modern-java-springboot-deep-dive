package com.example.springjava21.service;

import com.example.springjava21.dto.Task;
import com.example.springjava21.utils.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public interface TaskService {

    public Function<Task, Task> createTask();
    public Function<Integer, Task> getTaskById();
    public Function<Unit, List<Task>> getTasks();

    public Function<Task, Unit> deleteTask();


}
