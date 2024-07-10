package com.fabrixbau.apiREST.controllers;

import com.fabrixbau.apiREST.models.User;
import com.fabrixbau.apiREST.services.UserService;
import com.fabrixbau.apiREST.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

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

    // Register User
    @PostMapping("/")
    public void post(@RequestBody User user) {
        userService.post(user);
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


    // LOGIN
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto) {
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if (user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }
}
