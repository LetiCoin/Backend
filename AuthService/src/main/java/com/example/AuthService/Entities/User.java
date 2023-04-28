package com.example.AuthService.Entities;

import com.example.AuthService.Request.RegistrationRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role_id")
    private Long role;
    @Column(name = "status_id")
    private Long statusId;

    public User(RegistrationRequest request){
        this.email = request.getEmail();
        this.login = request.getLogin();
        if(request.getRole().equals("ROLE_TEACHER")) this.role = 1L;
        else if(request.getRole().equals("ROLE_STUDENT")) this.role = 2L;
        this.statusId = 0L;
    }
}
