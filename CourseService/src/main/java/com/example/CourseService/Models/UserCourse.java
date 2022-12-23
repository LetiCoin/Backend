package com.example.CourseService.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_courses")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "amount")
    private int amount;
    @Column(name = "role")
    private String role;

    public UserCourse(){}

    public UserCourse(UserCourseDto userCourseDto){
        this.userId = userCourseDto.getUserId();
        this.courseId = userCourseDto.getCourseId();
        this.amount = userCourseDto.getAmount();
        this.role = userCourseDto.getRole();
    }
}
