package com.example.crimerecordmanagement.controller;

import com.example.crimerecordmanagement.entity.Punishment;
import com.example.crimerecordmanagement.service.PunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/punishments")
public class PunishmentController {

    @Autowired
    private PunishmentService punishmentService;

    @GetMapping
    public List<Punishment> getAllPunishments() {
        return punishmentService.getAllPunishments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Punishment> getPunishmentById(@PathVariable Long id) {
        return punishmentService.getPunishmentById(id)
                .map(punishment -> ResponseEntity.ok().body(punishment))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Punishment> addPunishment(@Valid @RequestBody Punishment punishment) {
        Punishment savedPunishment = punishmentService.savePunishment(punishment);
        return new ResponseEntity<>(savedPunishment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Punishment> updatePunishment(@PathVariable Long id, @Valid @RequestBody Punishment punishmentDetails) {
        return punishmentService.getPunishmentById(id)
                .map(punishment -> {
                    punishment.setPunishmentType(punishmentDetails.getPunishmentType());
                    punishment.setStartDate(punishmentDetails.getStartDate());
                    punishment.setEndDate(punishmentDetails.getEndDate());
                    Punishment updatedPunishment = punishmentService.savePunishment(punishment);
                    return ResponseEntity.ok().body(updatedPunishment);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePunishment(@PathVariable Long id) {
        return punishmentService.getPunishmentById(id)
                .map(punishment -> {
                    punishmentService.deletePunishment(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
