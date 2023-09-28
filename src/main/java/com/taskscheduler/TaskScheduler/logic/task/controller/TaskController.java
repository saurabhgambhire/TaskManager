package com.taskscheduler.TaskScheduler.logic.task.controller;

import com.taskscheduler.TaskScheduler.logic.task.entity.Task;
import com.taskscheduler.TaskScheduler.logic.task.service.TaskCRUDOps;
import com.taskscheduler.TaskScheduler.modelsResponse.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskCRUDOps taskCRUDOps;

    @PostMapping("/create")
    StatusResponse createTask(@RequestBody Task task) throws ParseException {
        return taskCRUDOps.createTask(task);
    }

    @GetMapping("/get/all")
    StatusResponse getAllTasks(@RequestParam String userId) {
        return taskCRUDOps.getAllTasks(userId);
    }

    @DeleteMapping("/delete")
    StatusResponse deleteTask(@RequestParam int id, @RequestParam String userId) {
        return taskCRUDOps.deleteTask(id, userId);
    }

    @PutMapping("/update")
    StatusResponse updateTask(@RequestBody Task task) throws ParseException {
        return taskCRUDOps.updateTask(task);
    }
}
