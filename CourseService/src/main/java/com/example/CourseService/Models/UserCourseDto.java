package com.example.CourseService.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserCourseDto {
    private Long userId;
    private Long courseId;
    private String name;
    private int amount;
    private String role;

    public UserCourseDto(UserCourse userCourse, Course course){
        this.userId = userCourse.getUserId();
        this.courseId = course.getId();
        this.name = course.getName();
        this.amount = userCourse.getAmount();
        this.role = userCourse.getRole();
    }

}
