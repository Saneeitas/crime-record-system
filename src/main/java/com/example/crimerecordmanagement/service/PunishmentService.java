package com.example.crimerecordmanagement.service;

import com.example.crimerecordmanagement.entity.Punishment;
import com.example.crimerecordmanagement.repository.PunishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PunishmentService {

    @Autowired
    private PunishmentRepository punishmentRepository;

    public List<Punishment> getAllPunishments() {
        return punishmentRepository.findAll();
    }

    public Optional<Punishment> getPunishmentById(Long id) {
        return punishmentRepository.findById(id);
    }

    public Punishment savePunishment(Punishment punishment) {
        return punishmentRepository.save(punishment);
    }

    public void deletePunishment(Long id) {
        punishmentRepository.deleteById(id);
    }
}
