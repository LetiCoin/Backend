package com.example.AuthService.Services;

import com.example.AuthService.Entities.Role;
import com.example.AuthService.Entities.Status;
import com.example.AuthService.Entities.User;

public interface UserService {
    User register(User user);
    User save(User user);
    User findByLogin(String login);
    User findById(Long id);
    Role findByRoleId(Long id);
    Status findByStatusId(Long id);
}
