package com.example.crimerecordmanagement.service;

import com.example.crimerecordmanagement.entity.Crime;
import com.example.crimerecordmanagement.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrimeService {

    @Autowired
    private CrimeRepository crimeRepository;

    public List<Crime> getAllCrimes() {
        return crimeRepository.findAll();
    }

    public Optional<Crime> getCrimeById(Long id) {
        return crimeRepository.findById(id);
    }

    public Crime saveCrime(Crime crime) {
        return crimeRepository.save(crime);
    }

    public void deleteCrime(Long id) {
        crimeRepository.deleteById(id);
    }
}
