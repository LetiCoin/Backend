package com.example.CourseService.Services;

import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;
import com.example.CourseService.Models.UserCourseDto;

import java.util.List;

public interface CourseService {
    List<UserCourse> findAllByUserId(Long userId);
    List<UserCourseDto> refactor(List<UserCourse> userCourses);
    UserCourse checkUserCourse(UserCourse userCourse);
    Course findById(Long id);
    UserCourse addCourse(UserCourseDto userCourseDto);
    UserCourse findByUserIdAndCourseId(Long userId,Long courseId);
    List<Course> findAll();
    void save(UserCourse userCourse);
}
