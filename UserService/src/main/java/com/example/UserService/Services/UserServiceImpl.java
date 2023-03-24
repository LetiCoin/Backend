//package com.example.UserService.Services;
//
//import com.example.UserService.Models.User;
//import com.example.UserService.Models.UserCourseDto;
//import com.example.UserService.Repos.UserRepo;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService{
//    private final UserRepo userRepo;
//    private final AmqpTemplate amqpTemplate;
//    private ObjectMapper mapper = new ObjectMapper();
//    UserServiceImpl(UserRepo userRepo,
//                    AmqpTemplate amqpTemplate){
//        this.userRepo = userRepo;
//        this.amqpTemplate = amqpTemplate;
//    }
//    @Override
//    public User register(User user) {
//        userRepo.save(user);
//        return user;
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        return userRepo.findByUsername(username).orElse(null);
//    }
//
//    @Override
//    public User findById(Long id) {
//        return userRepo.findById(id).orElse(null);
//    }
//
//    @Override
//    public UserCourseDto addCourse(Long courseId, Long userId) {
//        try{
//            UserCourseDto userCourseDto = new UserCourseDto();
//            userCourseDto.setCourseId(courseId);
//            userCourseDto.setUserId(userId);
//            userCourseDto.setAmount(0);
//            userCourseDto.setRole("STUDENT_ROLE");
//
//            amqpTemplate.convertAndSend("UserCourse",mapper.writeValueAsString(userCourseDto));
//
//
//            return userCourseDto;
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Override
//    public List<UserCourseDto> getUserCourses(Long userId) {
//        List<UserCourseDto> answer = restTemplate.getForObject("/course/list" + userId, List.class);
//        return null;
//    }
//}
