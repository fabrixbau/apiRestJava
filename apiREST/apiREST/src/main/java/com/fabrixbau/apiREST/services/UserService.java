package com.fabrixbau.apiREST.services;

import com.fabrixbau.apiREST.models.User;
import com.fabrixbau.apiREST.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User post(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}