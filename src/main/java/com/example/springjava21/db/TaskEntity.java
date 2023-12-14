package com.example.springjava21.db;


import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Task")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private boolean completed;
}
