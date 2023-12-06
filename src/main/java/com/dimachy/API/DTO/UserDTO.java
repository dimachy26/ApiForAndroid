package com.dimachy.API.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long userId;
    private String firstName;
    private String secondName;
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;
    private int age;
    private String number;
    private String login;
    private String password;
    private String email;
}
