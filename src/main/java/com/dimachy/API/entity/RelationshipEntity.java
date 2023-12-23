package com.dimachy.API.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "relations", schema = "hospital")
public class RelationshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationshipId;
    private int userId;
    private int doctorId;
}
