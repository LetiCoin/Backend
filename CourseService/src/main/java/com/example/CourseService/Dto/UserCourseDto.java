package com.example.CourseService.Dto;

import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCourseDto {

    private Course course;
    private String role;
    private int value;
    public UserCourseDto(Course course, int value){
        this.course = course;
        this.value = value;
    }
}
