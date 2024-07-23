package com.example.crimerecordmanagement.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crimes")
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "criminal_id", nullable = false)
    private Criminal criminal;

    @Column(name = "crime_type", nullable = false)
    private String crimeType;

    private String description;

    @Column(name = "date_of_crime", nullable = false)
    private LocalDate dateOfCrime;

    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate updatedAt;

    // Getters and Setters
}
