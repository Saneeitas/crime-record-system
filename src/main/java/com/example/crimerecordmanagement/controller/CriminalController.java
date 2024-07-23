package com.example.crimerecordmanagement.controller;

import com.example.crimerecordmanagement.entity.Criminal;
import com.example.crimerecordmanagement.service.CriminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/criminals")
public class CriminalController {

    @Autowired
    private CriminalService criminalService;

    @GetMapping
    public List<Criminal> getAllCriminals() {
        return criminalService.getAllCriminals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criminal> getCriminalById(@PathVariable Long id) {
        return criminalService.getCriminalById(id)
                .map(criminal -> ResponseEntity.ok().body(criminal))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping
    public ResponseEntity<Criminal> addCriminal(@Valid @RequestBody Criminal criminal) {
        Criminal savedCriminal = criminalService.saveCriminal(criminal);
        return new ResponseEntity<>(savedCriminal, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Criminal> updateCriminal(@PathVariable Long id, @Valid @RequestBody Criminal criminalDetails) {
        return criminalService.getCriminalById(id)
                .map(criminal -> {
                    criminal.setName(criminalDetails.getName());
                    criminal.setDateOfBirth(criminalDetails.getDateOfBirth());
                    criminal.setGender(criminalDetails.getGender());
                    criminal.setAddress(criminalDetails.getAddress());
                    Criminal updatedCriminal = criminalService.saveCriminal(criminal);
                    return ResponseEntity.ok().body(updatedCriminal);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriminal(@PathVariable Long id) {
        return criminalService.getCriminalById(id)
                .map(criminal -> {
                    criminalService.deleteCriminal(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
