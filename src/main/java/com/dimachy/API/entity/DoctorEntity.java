package com.dimachy.API.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "doctors", schema = "hospital")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String firstName;
    private String secondName;
    private String lastName;
    private String healthPosition;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;
    private int seniority;
}
