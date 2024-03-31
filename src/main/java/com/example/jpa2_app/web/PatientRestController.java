package com.example.jpa2_app.web;

import com.example.jpa2_app.entities.Patient;
import com.example.jpa2_app.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    //crre un controlleur  qui permet consulter liste patient
    @GetMapping("/patients")
    public List<Patient>patientList(){
        return patientRepository.findAll();
    }
}
