package com.example.UserService.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ActivationDto {
    private String login;
    private String firstname;
    private String lastname;
    private String email;
}
