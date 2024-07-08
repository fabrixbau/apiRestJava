package com.fabrixbau.apiREST.controllers;

import com.fabrixbau.apiREST.models.User;
import com.fabrixbau.apiREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    // Register Userr
    @PostMapping("/")
    public User post(@RequestBody User user) {
        return userService.post(user);
    }

    // Update User
    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    // Delete User
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }
}
