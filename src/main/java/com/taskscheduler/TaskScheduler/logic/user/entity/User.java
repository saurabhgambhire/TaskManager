package com.taskscheduler.TaskScheduler.logic.user.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Column(unique = true)
    private String userId;
    private String name;
    @Id
    private String email;
    private String mobile;
    private String password;

    public User() {
    }

    public User(String userId, String name, String email, String mobile, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }
}
