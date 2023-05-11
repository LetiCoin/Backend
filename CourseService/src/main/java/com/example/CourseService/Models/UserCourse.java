package com.example.CourseService.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_course")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "cousre_id")
    private Long courseId;
    @Column(name = "user_login")
    private String userLogin;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "value")
    private int value;

    public UserCourse(Long courseId, String userLogin, Long roleId){
        this.courseId = courseId;
        this.userLogin = userLogin;
        this.roleId = roleId;
        this.value = 0;
    }
}
