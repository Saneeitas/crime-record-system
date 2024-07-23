package com.example.crimerecordmanagement.service;

import com.example.crimerecordmanagement.entity.Criminal;
import com.example.crimerecordmanagement.repository.CriminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalService {

    @Autowired
    private CriminalRepository criminalRepository;

    public List<Criminal> getAllCriminals() {
        return criminalRepository.findAll();
    }

    public Optional<Criminal> getCriminalById(Long id) {
        return criminalRepository.findById(id);
    }

    public Criminal saveCriminal(Criminal criminal) {
        return criminalRepository.save(criminal);
    }

    public void deleteCriminal(Long id) {
        criminalRepository.deleteById(id);
    }
}
