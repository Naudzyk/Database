package com.zhenya.ru.Datadase.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_user")
    private String role_user;

}
