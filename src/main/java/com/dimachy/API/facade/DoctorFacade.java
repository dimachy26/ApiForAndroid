package com.dimachy.API.facade;

import com.dimachy.API.entity.DoctorEntity;
import com.dimachy.API.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorFacade {
    public final DoctorService doctorService;

    public List<DoctorEntity> getDoctorsByUserId(Long userId) {
        return doctorService.getDoctorsByUserId(userId);
    }
}
