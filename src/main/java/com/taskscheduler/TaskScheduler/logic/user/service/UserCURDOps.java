package com.taskscheduler.TaskScheduler.logic.user.service;

import com.taskscheduler.TaskScheduler.constants.Constants;
import com.taskscheduler.TaskScheduler.logic.user.entity.User;
import com.taskscheduler.TaskScheduler.logic.user.repository.UserRepository;
import com.taskscheduler.TaskScheduler.modelsResponse.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCURDOps {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TwilioService twilioService;


    public StatusResponse save(User user) {
        if (user.getUserId() == null)
            user.setUserId(UUID.randomUUID().toString());


        return new StatusResponse(
                true,
                "User Saved successfully",
                userRepository.save(user)
        );
    }

    public StatusResponse login(String email, String password) {

        User user = userRepository.findByEmailAndPassword(email, password);

        if (user == null) {
            return new StatusResponse(
                    false,
                    "Incorrect username or password"
            );
        }

        return new StatusResponse(
                true,
                "Login Request Succeeded",
                user
        );
    }

    public StatusResponse deleteUser(String email, String password) {
        Optional<User> byId = userRepository.findById(email);

        if (byId.isEmpty() || !byId.get().getPassword().equals(password)) {
            return new StatusResponse(
                    false,
                    "Incorrect username or password"
            );
        }

        userRepository.delete(byId.get());
        return new StatusResponse(
                true,
                "User deleted Successfully"
        );
    }
}
