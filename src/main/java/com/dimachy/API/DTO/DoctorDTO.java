package com.dimachy.API.DTO;

import lombok.Data;

@Data
public class DoctorDTO {
    private String firstName;
    private String secondName;
    private String lastName;
    private String healthPosition;
    private int seniority;
}
