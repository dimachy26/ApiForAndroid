package com.dimachy.API;

import com.dimachy.API.DTO.RegistrationResponse;
import com.dimachy.API.DTO.UserDTO;
import com.dimachy.API.entity.DoctorEntity;
import com.dimachy.API.entity.UserEntity;
import com.dimachy.API.exception.AuthorizationException;
import com.dimachy.API.facade.DoctorFacade;
import com.dimachy.API.facade.UserFacade;
import com.dimachy.API.service.DoctorService;
import com.dimachy.API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class Controller {

    private final UserFacade userFacade;
    private final UserService userService;
    private final DoctorService doctorService;
    private final DoctorFacade doctorFacade;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        try {
            UserDTO userDTO = userFacade.login(user);
            return ResponseEntity.ok(userFacade.login(user));
        } catch (AuthorizationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody UserDTO dto) {
        RegistrationResponse registrationResponse = userService.registration(dto);
        if (registrationResponse.isSuccess()) {
            return ResponseEntity.ok(Map.of("status", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(registrationResponse);
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUserData(
            @PathVariable Long userId,
            @RequestBody UserDTO updatedUserData) {
        try {
            userService.updateUserData(userId, updatedUserData);
            return ResponseEntity.ok(Map.of("status", "success"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + userId);
        }
    }

    @GetMapping("/doctors/{userId}")
    public ResponseEntity<?> getDoctorsByUserId(@PathVariable Long userId) {
        try {
            List<DoctorEntity> doctors = doctorFacade.getDoctorsByUserId(userId);
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving doctors");
        }
    }
}
