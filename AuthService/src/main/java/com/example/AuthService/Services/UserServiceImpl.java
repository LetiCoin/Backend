package com.example.AuthService.Services;

import com.example.AuthService.Entities.Role;
import com.example.AuthService.Entities.Status;
import com.example.AuthService.Entities.User;
import com.example.AuthService.Repos.RoleRepo;
import com.example.AuthService.Repos.StatusRepo;
import com.example.AuthService.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final StatusRepo statusRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, RoleRepo roleRepo, StatusRepo statusRepo){
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.statusRepo = statusRepo;
    }
    @Override
    public User register(User user) {
        if(this.findByLogin(user.getLogin()) != null) return null;
        else{
            userRepo.save(user);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login).orElse(null);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public Role findByRoleId(Long id) { return roleRepo.findById(id).orElse(null); }

    @Override
    public Status findByStatusId(Long id) { return statusRepo.findById(id).orElse(null); }
}
