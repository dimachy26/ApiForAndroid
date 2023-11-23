package com.dimachy.API.service;

import com.dimachy.API.DTO.RegistrationResponse;
import com.dimachy.API.DTO.UserDTO;
import com.dimachy.API.entity.UserEntity;
import com.dimachy.API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public RegistrationResponse registration(UserDTO dto) {
        List<String> duplicateFields = new ArrayList<>();

        if (userRepository.findByLogin(dto.getLogin()).isPresent()) {
            duplicateFields.add("login");
        }
        if (userRepository.findByNumber(dto.getNumber()).isPresent()) {
            duplicateFields.add("number");
        }
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            duplicateFields.add("email");
        }
        if (!duplicateFields.isEmpty()) {
            return new RegistrationResponse(false, duplicateFields);
        }

            UserEntity response = UserEntity.builder()
                    .firstName(dto.getFirstName())
                    .secondName(dto.getSecondName())
                    .lastName(dto.getLastName())
                    .birthdate(dto.getBirthdate())
                    .email(dto.getEmail())
                    .number(dto.getNumber())
                    .login(dto.getLogin())
                    .password(dto.getPassword())
                    .age(Period.between(dto.getBirthdate(), LocalDate.now()).getYears())
                    .build();
            userRepository.save(response);

            return new RegistrationResponse(true, null);
    }
}