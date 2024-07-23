package com.example.crimerecordmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "punishments")
public class Punishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crime_id", nullable = false)
    private Crime crime;

    @Column(name = "punishment_type", nullable = false)
    private String punishmentType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate updatedAt;

    // Getters and Setters
}
