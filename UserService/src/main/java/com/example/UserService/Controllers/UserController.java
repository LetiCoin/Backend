package com.example.UserService.Controllers;

import com.example.UserService.Models.User;
import com.example.UserService.Models.UserCourseDto;
import com.example.UserService.Models.UserRegDto;
import com.example.UserService.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public User homepage(@RequestHeader(value = "username") String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/add/{courseId}")
    public UserCourseDto add(@PathVariable("courseId") Long courseId, @RequestHeader("id") Long userId){
        return userService.addCourse(courseId,userId);
    }

}
