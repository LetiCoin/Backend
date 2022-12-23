package com.example.CourseService.Controllers;

import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourseDto;
import com.example.CourseService.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course/preview/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> all(){
        return courseService.findAll();
    }

    @GetMapping("/list")
    public List<UserCourseDto> list(@RequestHeader(value = "id") Long userId){
        return courseService.refactor(courseService.findAllByUserId(userId));
    }

    @GetMapping("/{courseId}")
    public Course coursePage(@PathVariable("courseId") Long courseId){
        return courseService.findById(courseId);
    }

}
