package com.example.CourseService.Repos;

import com.example.CourseService.Models.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCourseRepo extends JpaRepository<UserCourse,Long> {
    List<UserCourse> findAllByUserId(Long userId);
    List<UserCourse> findAllByCourseId(Long courseId);
    Optional<UserCourse> findByCourseIdAndUserId(Long courseId, Long userId);
}
