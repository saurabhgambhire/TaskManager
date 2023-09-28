package com.taskscheduler.TaskScheduler.logic.task.service;

import com.taskscheduler.TaskScheduler.constants.Constants;
import com.taskscheduler.TaskScheduler.logic.task.entity.Task;
import com.taskscheduler.TaskScheduler.logic.task.repository.TaskRepo;
import com.taskscheduler.TaskScheduler.modelsResponse.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class TaskCRUDOps {
    @Autowired
    private TaskRepo taskRepo;

    public StatusResponse createTask(Task task) throws ParseException {
        SimpleDateFormat dateFormatter = Constants.getDateFormatter();
        String format = dateFormatter.format(task.getDate());
        task.setDate(dateFormatter.parse(format));

        taskRepo.save(task);
        return new StatusResponse(
                true,
                "Task Saved Successfully"
        );
    }

    public StatusResponse getAllTasks(String userid) {
        if (userid == null)
            return new StatusResponse(
                    false,
                    "Please provide UserId"
            );
        List<Task> byUserid = taskRepo.findByUserid(userid);
        if (byUserid.isEmpty())
            return new StatusResponse(
                    false,
                    "No Task found with Given userId"
            );

        return new StatusResponse(
                true,
                "Tasks found with given user Id",
                byUserid
        );
    }

    public StatusResponse deleteTask(int id, String userId) {
        Optional<Task> byId = taskRepo.findById(id);
        if (byId.isEmpty() || !byId.get().getUserid().equals(userId))
            return new StatusResponse(
                    false,
                    "Incorrect Task Id and User Id"
            );

        taskRepo.delete(byId.get());
        return new StatusResponse(
                true,
                "Task Deleted Successfully"
        );
    }

    public StatusResponse updateTask(Task task) throws ParseException {
        Task existingTask = taskRepo.findById(task.getId()).orElse(null);
        if (existingTask == null)
            return new StatusResponse(
                    false,
                    "Task not found");

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.isStatus());

        SimpleDateFormat dateFormatter = Constants.getDateFormatter();
        String format = dateFormatter.format(task.getDate());
        existingTask.setDate(dateFormatter.parse(format));

        existingTask.setUserid(task.getUserid());

        taskRepo.save(existingTask);
        return new StatusResponse(
                true,
                "Task Updated Successfully"
        );

    }
}
