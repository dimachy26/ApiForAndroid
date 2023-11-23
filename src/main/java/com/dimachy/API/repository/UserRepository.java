package com.dimachy.API.repository;


import com.dimachy.API.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByNumber(String number);
    Optional<UserEntity> findByEmail(String email);
}

