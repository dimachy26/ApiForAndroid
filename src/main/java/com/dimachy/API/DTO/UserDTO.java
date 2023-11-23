package com.dimachy.API.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long userId;
    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDate birthdate;
    private int age;
    private String number;
    private String login;
    private String password;
    private String email;
}
