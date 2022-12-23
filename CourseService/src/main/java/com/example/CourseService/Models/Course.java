package com.example.CourseService.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

}
