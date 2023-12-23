package com.dimachy.API.repository;

import com.dimachy.API.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    @Query("SELECT d FROM DoctorEntity d " +
            "JOIN RelationshipEntity r ON d.doctorId = r.doctorId " +
            "JOIN UserEntity u ON r.userId = u.userId " +
            "WHERE u.userId = :userId")
    List<DoctorEntity> getDoctorsByUserId(@Param("userId") Long userId);
}
