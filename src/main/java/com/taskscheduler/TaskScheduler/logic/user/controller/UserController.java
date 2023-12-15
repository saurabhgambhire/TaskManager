package com.taskscheduler.TaskScheduler.logic.user.controller;

import com.taskscheduler.TaskScheduler.logic.user.entity.User;
import com.taskscheduler.TaskScheduler.modelsResponse.StatusResponse;
import com.taskscheduler.TaskScheduler.logic.user.service.UserCURDOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserCURDOps userCURDOps;

    @Autowired
    public UserController(UserCURDOps userCURDOps) {
        this.userCURDOps = userCURDOps;
    }


    @PostMapping("/signup")
    StatusResponse saveUser(@RequestBody User user) {
        return userCURDOps.save(user);
    }

    @GetMapping("/login")
    StatusResponse loginUser(@RequestParam String email, @RequestParam String password) {
        return userCURDOps.login(email, password);
    }

    @DeleteMapping("/delete")
    StatusResponse deleteUser(@RequestParam String email, @RequestParam String password) {
        return userCURDOps.deleteUser(email, password);
    }

    @PutMapping("/update")
    StatusResponse updateUser(@RequestBody User user) {
        return userCURDOps.save(user);
    }


}
