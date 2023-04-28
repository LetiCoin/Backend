package com.example.UserService.mq;

import com.example.UserService.Dto.ActivationDto;
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

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "[LetiCoin]ActivationAcc") //Activation Request
    public void authentication(String msg) {
        try{
            ActivationDto newUser = mapper.readValue(msg, ActivationDto.class);
            User user = userService.addUser(newUser);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

}
