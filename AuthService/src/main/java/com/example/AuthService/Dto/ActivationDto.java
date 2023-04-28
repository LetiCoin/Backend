package com.example.AuthService.Dto;

import com.example.AuthService.Entities.User;
import com.example.AuthService.Request.ActivationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationDto {
    private String login;
    private String firstname;
    private String lastname;
    private String email;

    public ActivationDto(ActivationRequest activationRequest, User user){
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.firstname = activationRequest.getFirstname();
        this.lastname = activationRequest.getLastname();
    }
}
