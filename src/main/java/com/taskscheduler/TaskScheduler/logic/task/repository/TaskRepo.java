package com.taskscheduler.TaskScheduler.logic.task.repository;

import com.taskscheduler.TaskScheduler.logic.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByUserid(String userid);
}
