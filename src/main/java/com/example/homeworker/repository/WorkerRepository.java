package com.example.homeworker.repository;

import com.example.homeworker.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findByChatId(long chatId);
}
