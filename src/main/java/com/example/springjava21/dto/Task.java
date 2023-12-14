package com.example.springjava21.dto;

import java.time.LocalDate;

public record Task(int taskId, String title, String description, TaskStatus status, LocalDate dueDate, boolean completed) {
    public Task() {
        this(0, "", "", null, LocalDate.now(), false);
    }
}
