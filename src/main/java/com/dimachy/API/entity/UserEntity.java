package com.dimachy.API.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table (name = "users")
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;
        private String firstName;
        private String secondName;
        private String lastName;
        private LocalDate birthdate;
        private String number;
        private String login;
        private String password;
}