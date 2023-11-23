package com.dimachy.API;

import com.dimachy.API.DTO.RegistrationResponse;
import com.dimachy.API.DTO.UserDTO;
import com.dimachy.API.entity.UserEntity;
import com.dimachy.API.exception.AuthorizationException;
import com.dimachy.API.facade.UserFacade;
import com.dimachy.API.repository.UserRepository;
import com.dimachy.API.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class Controller {

    private final UserFacade userFacade;
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        try{
            UserDTO userDTO = userFacade.login(user);
            return ResponseEntity.ok(userFacade.login(user));
        } catch (AuthorizationException e){
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
}
