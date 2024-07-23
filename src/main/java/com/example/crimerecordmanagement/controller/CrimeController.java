package com.example.crimerecordmanagement.controller;

import com.example.crimerecordmanagement.entity.Crime;
import com.example.crimerecordmanagement.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/crimes")
public class CrimeController {

    @Autowired
    private CrimeService crimeService;

    @GetMapping
    public List<Crime> getAllCrimes() {
        return crimeService.getAllCrimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crime> getCrimeById(@PathVariable Long id) {
        return crimeService.getCrimeById(id)
                .map(crime -> ResponseEntity.ok().body(crime))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Crime> addCrime(@Valid @RequestBody Crime crime) {
        Crime savedCrime = crimeService.saveCrime(crime);
        return new ResponseEntity<>(savedCrime, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crime> updateCrime(@PathVariable Long id, @Valid @RequestBody Crime crimeDetails) {
        return crimeService.getCrimeById(id)
                .map(crime -> {
                    crime.setCrimeType(crimeDetails.getCrimeType());
                    crime.setDescription(crimeDetails.getDescription());
                    crime.setDateOfCrime(crimeDetails.getDateOfCrime());
                    Crime updatedCrime = crimeService.saveCrime(crime);
                    return ResponseEntity.ok().body(updatedCrime);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrime(@PathVariable Long id) {
        return crimeService.getCrimeById(id)
                .map(crime -> {
                    crimeService.deleteCrime(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
