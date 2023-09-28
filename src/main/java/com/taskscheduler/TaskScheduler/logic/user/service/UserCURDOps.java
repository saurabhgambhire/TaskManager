package com.taskscheduler.TaskScheduler.logic.user.service;

import com.taskscheduler.TaskScheduler.constants.Constants;
import com.taskscheduler.TaskScheduler.logic.user.entity.User;
import com.taskscheduler.TaskScheduler.logic.user.repository.UserRepository;
import com.taskscheduler.TaskScheduler.modelsResponse.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCURDOps {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TwilioService twilioService;


    public StatusResponse save(User user) {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            user.setUserId(UUID.randomUUID().toString());
            userRepository.save(user);
            twilioService.sendSMS(user.getMobile(), "Account Created Successfully : @Author : Saurabh Gambhire");

            return new StatusResponse(
                    true,
                    "User Saved Successfully",
                    user
            );
        }

        return new StatusResponse(
                false,
                "A user with that E-mail already exists"
        );

    }

    public StatusResponse login(String email, String password) {

        Optional<User> byId = userRepository.findById(email);

        if (byId.isEmpty() || !byId.get().getPassword().equals(password)) {
            return new StatusResponse(
                    false,
                    "Incorrect username or password"
            );
        }

        return new StatusResponse(
                true,
                "Login Request Succeeded",
                byId
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
