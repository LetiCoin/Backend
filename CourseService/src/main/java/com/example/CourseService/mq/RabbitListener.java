package com.example.CourseService.mq;

import com.example.CourseService.Services.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private CourseService courseService;

//    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "UserCourse")
//    public void newUserCourse(String msg) {
//        try{
//            UserCourseDto newUserCourse = mapper.readValue(msg, UserCourseDto.class);
//            courseService.addCourse(newUserCourse);
//        }catch (JsonProcessingException e){
//            throw new RuntimeException(e);
//        }
//    }

//    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "TaskCourse")
//    public void addValueToUserCourse(String msg) {
//        try{
//            RewardDto reward = mapper.readValue(msg, RewardDto.class);
//            UserCourse userCourse = courseService.findByUserIdAndCourseId(reward.getUserId(), reward.getCourseId());
//            userCourse.setAmount(userCourse.getAmount() + reward.getValue());
//            courseService.save(userCourse);
//        }catch (JsonProcessingException e){
//            throw new RuntimeException(e);
//        }
//    }

}