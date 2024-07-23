package com.example.crimerecordmanagement.repository;

import com.example.crimerecordmanagement.entity.Punishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PunishmentRepository extends JpaRepository<Punishment, Long> {
}
