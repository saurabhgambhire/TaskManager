package com.taskscheduler.TaskScheduler.logic.user.repository;

import com.taskscheduler.TaskScheduler.logic.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAndPassword(String identifier, String password);
}
