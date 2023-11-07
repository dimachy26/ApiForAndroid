package com.dimachy.API;

import com.dimachy.API.DTO.UserResponseDTO;
import com.dimachy.API.entity.UserEntity;
import com.dimachy.API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findByLogin(user.getLogin());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            UserResponseDTO response = new UserResponseDTO();
            response.setUserId(existingUser.get().getUserId());
            response.setFirstName(existingUser.get().getFirstName());
            response.setSecondName(existingUser.get().getSecondName());
            response.setLastName(existingUser.get().getLastName());
            response.setBirthdate(existingUser.get().getBirthdate());
            response.setNumber(existingUser.get().getNumber());
            response.setLogin(existingUser.get().getLogin());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
