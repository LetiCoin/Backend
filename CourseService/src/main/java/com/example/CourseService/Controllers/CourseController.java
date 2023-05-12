package com.example.CourseService.Controllers;

import com.example.CourseService.Dto.CourseDto;
import com.example.CourseService.Dto.UserCourseDto;
import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;
import com.example.CourseService.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/service/course/preview")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> all(){
        return courseService.findAll();
    }

    @PostMapping("/create")
    public CourseDto create(@RequestHeader("login") String login,
                            @RequestHeader("role") String role,
                            @RequestBody CourseDto courseDto){
        return courseService.create(courseDto,login,role);
    }
    @GetMapping("{courseId}")
    public UserCourseDto getById(@PathVariable("courseId") Long id,
                                 @RequestHeader("login") String login){
        return courseService.findById(id,login);
    }

    @PostMapping("/subscribe/{courseId}")
    public UserCourseDto subscribe(@PathVariable("courseId") Long id,
                                   @RequestHeader("login") String login){
        return courseService.subscribe(id,login);
    }
}
