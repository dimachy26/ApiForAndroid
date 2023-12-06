package com.dimachy.API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "hospital")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String secondName;
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;
    private String number;
    private String login;
    private String password;
    private String email;
    private int age;
}