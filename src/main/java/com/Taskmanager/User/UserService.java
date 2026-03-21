package com.Taskmanager.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public String login(User user) {
        User dbUser = repo.findByEmail(user.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "dummy-token";
    }

    public User register(User user) {
        return repo.save(user);
    }
}