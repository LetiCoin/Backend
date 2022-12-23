package com.example.CourseService.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDto {

    private Long userId;
    private Long courseId;
    private int value;

}
