package com.fabrixbau.apiREST.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fabrixbau.apiREST.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
