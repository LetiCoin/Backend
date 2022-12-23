package com.example.CourseService.Services;

import com.example.CourseService.Models.Course;
import com.example.CourseService.Models.UserCourse;
import com.example.CourseService.Models.UserCourseDto;
import com.example.CourseService.Repos.CourseRepo;
import com.example.CourseService.Repos.UserCourseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepo courseRepo;
    private final UserCourseRepo userCourseRepo;
    CourseServiceImpl(CourseRepo courseRepo, UserCourseRepo userCourseRepo){
        this.courseRepo = courseRepo;
        this.userCourseRepo = userCourseRepo;
    }
    @Override
    public List<UserCourse> findAllByUserId(Long userId) {
        return userCourseRepo.findAllByUserId(userId);
    }

    @Override
    public List<UserCourseDto> refactor(List<UserCourse> userCourses) {
        List<UserCourseDto> answer = new ArrayList<>();
        for (UserCourse item:userCourses) {
            Course course = this.findById(item.getCourseId());
            if(course == null) continue;
            answer.add(new UserCourseDto(item,course));
        }
        return answer;
    }

    @Override
    public UserCourse checkUserCourse(UserCourse userCourse) {
        return userCourseRepo.findByCourseIdAndUserId(userCourse.getCourseId(), userCourse.getUserId()).orElse(null);
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public UserCourse addCourse(UserCourseDto newUserCourse) {
        Course course = this.findById(newUserCourse.getCourseId());
        if(course == null) return null;
        UserCourse userCourse = new UserCourse(newUserCourse);
        if(this.checkUserCourse(userCourse) != null) return null;
        this.save(userCourse);
        return userCourse;
    }

    @Override
    public UserCourse findByUserIdAndCourseId(Long userId, Long courseId) {
        return userCourseRepo.findByCourseIdAndUserId(userId,courseId).orElse(null);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void save(UserCourse userCourse) {
        userCourseRepo.save(userCourse);
    }
}
