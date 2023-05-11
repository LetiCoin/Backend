package com.example.CourseService.Repos;

import com.example.CourseService.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface CourseRepo extends JpaRepository<Course,Long> {
    Optional<Course> findById(Long id);
    Optional<Course> findByName(String name);
    List<Course> findAll();
}
