//package com.example.UserService.Models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//
//
//@Entity
//@Data
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "username")
//    private String username;
//    @Column(name = "role")
//    private String role;
//    @Column(name = "firstName")
//    private String firstName;
//    @Column(name = "lastName")
//    private String lastName;
//    @Column(name = "email")
//    private String email;
//
//    public User(){}
//    public User(UserRegDto user) {
//        this.username = user.getUsername();
//        this.role = user.getRole();
//        this.firstName = user.getFirstname();
//        this.lastName = user.getLastname();
//        this.email = user.getEmail();
//    }
//
//}
