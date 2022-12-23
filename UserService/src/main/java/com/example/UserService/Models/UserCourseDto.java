package com.example.UserService.Models;

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

}