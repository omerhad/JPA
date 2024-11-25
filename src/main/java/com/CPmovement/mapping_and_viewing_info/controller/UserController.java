package com.CPmovement.mapping_and_viewing_info.controller;


import com.CPmovement.mapping_and_viewing_info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.CPmovement.mapping_and_viewing_info.service.UserService;
import com.CPmovement.mapping_and_viewing_info.entity.User;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody User user) {
        return userService.signIn(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateStatus")
    public User updateStatus(@RequestParam Long userId, @RequestParam String status) {
        return userService.updateStatus(userId, status);
    }

    @GetMapping("/getUser")
    public User getUserById(@RequestParam Long userId) {
        return userService.getUserById(userId);
    }
}