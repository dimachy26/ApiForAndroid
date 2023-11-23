package com.dimachy.API.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationResponse {
    private boolean success;
    private List<String> duplicateFields;

    public RegistrationResponse(boolean success, List<String> duplicateFields) {
        this.success = success;
        this.duplicateFields = duplicateFields;
    }
}
