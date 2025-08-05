package com.example.usersmanagementsoftware.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Check(constraints = "email REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$'")
@Check(constraints = "role='user 'or role='admin' ")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5,message = "Must be Length of name more than 4 ")
    @Column(columnDefinition = "varchar(50) not null")
    @NotEmpty(message = "Name must be not Empty !")
    private String name;

    @Size(min = 5,message = "Must be Length of name more than 4 ")
    @NotEmpty(message="username must be not Empty !")
    @Column(columnDefinition = "varchar(50) unique not null ")
    private String username;

    @NotEmpty(message = "password must be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;


    @NotEmpty(message="username must be not Empty !")
    @Column(columnDefinition = "varchar(70) unique not null ")
    private String email;

    @Column(columnDefinition = "varchar(5) not null")
    @NotEmpty(message="role must be not Empty !")
    @Pattern(regexp = "user|admin")
    private String role;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "age must be not null")
    private Integer age;

}
