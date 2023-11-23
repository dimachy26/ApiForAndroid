package com.dimachy.API.facade;

import com.dimachy.API.DTO.UserDTO;
import com.dimachy.API.entity.UserEntity;
import com.dimachy.API.exception.AuthorizationException;
import com.dimachy.API.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    public UserDTO login(UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findByLogin(user.getLogin());

        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            UserDTO response = new UserDTO();
            response.setUserId(existingUser.get().getUserId());
            response.setFirstName(existingUser.get().getFirstName());
            response.setSecondName(existingUser.get().getSecondName());
            response.setLastName(existingUser.get().getLastName());
            response.setBirthdate(existingUser.get().getBirthdate());
            response.setNumber(existingUser.get().getNumber());
            response.setLogin(existingUser.get().getLogin());
            response.setEmail(existingUser.get().getEmail());
            response.setAge(existingUser.get().getAge());
            return response;
        } else throw new AuthorizationException("Invalid credentials");
    }
}
