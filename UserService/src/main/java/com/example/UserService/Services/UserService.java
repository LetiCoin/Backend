package com.example.UserService.Services;

import com.example.UserService.Models.User;

import java.util.List;


public interface UserService {
    User save(User user);
    User findByUsername(String username);
    User findById(Long id);

    //    UserCourseDto addCourse(Long courseId, Long userId);

    //    List<UserCourseDto> getUserCourses(Long userId);

}
