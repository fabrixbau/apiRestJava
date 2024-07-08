package com.fabrixbau.apiREST.dao;

import com.fabrixbau.apiREST.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User get(long id);
    User post(User user);
    User update(User user);
    void delete(long id);
}
