package com.example.CourseService.Services;

import com.example.CourseService.Dto.CourseDto;
import com.example.CourseService.Dto.UserCourseDto;
import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.Role;
import com.example.CourseService.Models.UserCourse;
import com.example.CourseService.Repos.CourseRepo;
import com.example.CourseService.Repos.RoleRepo;
import com.example.CourseService.Repos.UserCourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepo courseRepo;
    private final UserCourseRepo userCourseRepo;
    private final RoleRepo roleRepo;
    CourseServiceImpl(CourseRepo courseRepo, UserCourseRepo userCourseRepo, RoleRepo roleRepo){
        this.courseRepo = courseRepo;
        this.userCourseRepo = userCourseRepo;
        this.roleRepo = roleRepo;
    }
    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public UserCourseDto findById(Long courseId, String login) {

        Course course = courseRepo.findById(courseId).orElse(null);
        if(course == null) {
            // exeption(Course not found)
            return null;
        }
        UserCourse userCourse = userCourseRepo.findByCourseIdAndUserLogin(course.getId(), login).orElse(null);
        UserCourseDto userCourseDto = new UserCourseDto(course, userCourse.getValue());
        Role role = roleRepo.findById(userCourse.getRoleId()).orElse(null);
        if(role == null){
            // exeption(Role not found)
            return null;
        }
        userCourseDto.setRole(role.getName());
        return userCourseDto;
    }

    @Override
    public UserCourseDto subscribe(Long courseId, String login) {
        Course course = courseRepo.findById(courseId).orElse(null);
        if(course == null) {
            // exeption(Course not found)
            return null;
        }
        UserCourse userCourse = userCourseRepo.findByCourseIdAndUserLogin(course.getId(), login).orElse(null);
        if(userCourse!=null){
            // exeption(User already on course)
            return null;
        }
        userCourse = new UserCourse(course.getId(),login,1L);
        userCourse = userCourseRepo.save(userCourse);
        UserCourseDto userCourseDto = new UserCourseDto(course, userCourse.getValue());
        Role role = roleRepo.findById(userCourse.getRoleId()).orElse(null);
        if(role == null){
            // exeption(Role not found)
            return null;
        }
        userCourseDto.setRole(role.getName());
        return userCourseDto;
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
