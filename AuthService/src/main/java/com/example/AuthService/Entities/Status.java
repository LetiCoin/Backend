package com.example.AuthService.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Status")
public class Status {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}