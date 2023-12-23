package com.dimachy.API.service;

import com.dimachy.API.entity.DoctorEntity;
import com.dimachy.API.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorEntity> getDoctorsByUserId(Long userId) {
        return doctorRepository.getDoctorsByUserId(userId);
    }
}
