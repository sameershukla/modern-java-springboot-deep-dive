package com.example.springjava21.service;

import com.example.springjava21.db.TaskEntity;
import com.example.springjava21.db.TaskRespository;
import com.example.springjava21.dto.Task;
import com.example.springjava21.dto.TaskStatus;
import com.example.springjava21.utils.Unit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class TaskServiceImpl implements TaskService{

    Logger logger = Logger.getLogger(TaskServiceImpl.class.getName());

    @Autowired
    private TaskRespository taskRespository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Function<Task, Task> createTask() {
        return task -> {
            log(task);
            TaskEntity taskEntity = convertToTaskEntity(task);
            taskRespository.save(taskEntity);
            return task;
        };
    }

    @Override
    public Function<Integer, Task> getTaskById() {
        return taskId -> {
            Optional<TaskEntity> optionalTaskEntity = taskRespository.findById(taskId);
            TaskEntity taskEntity = optionalTaskEntity
                    .orElseThrow(() ->  new IllegalArgumentException("Task not found"));
            return convertTaskEntityToDto(taskEntity);
        };
    }

    @Override
    public Function<Unit, List<Task>> getTasks() {
        return unit -> {
            List<TaskEntity> taskEntities = taskRespository.findAll();
            return taskEntities.stream()
                    .map(this::convertTaskEntityToDto)
                    .collect(Collectors.toList());
        };
    }

    private TaskEntity convertToTaskEntity(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        String taskStatus = processTask(task);
        taskEntity.setStatus(taskStatus);
        BeanUtils.copyProperties(task, taskEntity);
        return taskEntity;
    }

    private Task convertTaskEntityToDto(TaskEntity taskEntity) {
        return new Task(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(),
                fromString(taskEntity.getStatus()), taskEntity.getDueDate(), taskEntity.isCompleted());
    }

    private String processTask(Task task){
        return switch (task.status()){
            case OPEN -> "OPEN";
            case IN_PROGRESS -> "IN_PROGRESS";
            case COMPLETED -> "COMPLETED";
            case ARCHIVED -> "ARCHIVED";
        };
    }

    private TaskStatus fromString(String taskStatus){
        return switch (taskStatus.toUpperCase()){
            case "OPEN" -> TaskStatus.OPEN;
            case "IN_PROGRESS" -> TaskStatus.IN_PROGRESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            case "ARCHIVED" -> TaskStatus.ARCHIVED;
            default -> throw new IllegalArgumentException("Invalid Criteria");
        };
    }

    private void log(Task task){
        String request = """
               <li>
                   <strong>Task ID:</strong> %d<br>
                   <strong>Title:</strong> %s<br>
                   <strong>Description:</strong> %s<br>
                   <strong>Status:</strong> %s<br>
               </li>
               """.formatted(task.taskId(), task.title(), task.description(), task.status(), task.dueDate(), task.completed());
        logger.info(request);
    }
}
