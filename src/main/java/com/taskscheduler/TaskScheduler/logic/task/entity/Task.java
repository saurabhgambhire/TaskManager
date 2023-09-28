package com.taskscheduler.TaskScheduler.logic.task.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private Date date;
    private boolean status;
    private String userid;

    public Task() {
    }

    public Task(String title, String description, Date date, boolean status, String userid) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.userid = userid;
    }

    public Task(int id, String title, String description, Date date, boolean status, String userid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
        this.userid = userid;
    }
}
