package com.example.UserService.mq;

import com.example.UserService.Models.User;
//import com.example.UserService.Models.UserRegDto;
import com.example.UserService.Services.UserService;
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
    private UserService userService;

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "AuthUser") //from Auth to User service
    public void authentication(String msg) {
//        try{
//            UserRegDto newUser = mapper.readValue(msg, UserRegDto.class);
//            User user = new User(newUser);
//            userService.register(user);
//        }catch (JsonProcessingException e){
//            throw new RuntimeException(e);
//        }
    }

}
