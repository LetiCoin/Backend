package com.example.CourseService.Services;

import com.example.CourseService.Dto.CourseDto;
import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;
import com.example.CourseService.Repos.CourseRepo;
import com.example.CourseService.Repos.UserCourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepo courseRepo;
    private final UserCourseRepo userCourseRepo;
    CourseServiceImpl(CourseRepo courseRepo, UserCourseRepo userCourseRepo){
        this.courseRepo = courseRepo;
        this.userCourseRepo = userCourseRepo;
    }
    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public CourseDto create(CourseDto courseDto, String login, String role) {
        if(!role.equals("ROLE_TEACHER")){
            // throw exeption
            return null;
        }
        Course course = courseRepo.findByName(courseDto.getName()).orElse(null);
        if(course!=null){
            // throw exeption
            return null;
        }

        course = new Course(courseDto);
        course = courseRepo.save(course);


        UserCourse userCourse = new UserCourse(course.getId(), login, 0L);
        userCourseRepo.save(userCourse);


        return courseDto;
    }


}
