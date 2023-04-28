package com.example.UserService.Repos;

import com.example.UserService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
}
