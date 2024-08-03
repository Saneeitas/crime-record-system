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

    // Getters
    public Long getId() {
        return id;
    }

    public Criminal getCriminal() {
        return criminal;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOfCrime() {
        return dateOfCrime;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCriminal(Criminal criminal) {
        this.criminal = criminal;
    }

    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfCrime(LocalDate dateOfCrime) {
        this.dateOfCrime = dateOfCrime;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

}
