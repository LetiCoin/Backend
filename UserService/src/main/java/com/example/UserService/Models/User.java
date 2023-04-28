package com.example.UserService.Models;

import com.example.UserService.Dto.ActivationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;

    public User(ActivationDto activationDto){
        this.login = activationDto.getLogin();
        this.firstName = activationDto.getFirstname();
        this.lastName = activationDto.getLastname();
        this.email = activationDto.getEmail();
    }
}
