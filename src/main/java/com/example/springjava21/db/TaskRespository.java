package com.example.springjava21.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRespository extends JpaRepository<TaskEntity, Integer> {
}
