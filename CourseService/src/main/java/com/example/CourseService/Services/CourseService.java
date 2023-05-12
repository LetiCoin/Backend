package com.example.CourseService.Services;

import com.example.CourseService.Dto.CourseDto;
import com.example.CourseService.Dto.UserCourseDto;
import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    UserCourseDto findById(Long courseId, String login);
    UserCourseDto subscribe(Long courseId, String login);
    CourseDto create(CourseDto courseDto, String login, String role);
}
