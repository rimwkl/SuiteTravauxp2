package com.example.jpa2_app.repositories;

import com.example.jpa2_app.entities.Medecin;
import com.example.jpa2_app.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByNom(String name);


}
